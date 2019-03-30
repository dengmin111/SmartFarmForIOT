package com.nuc.SerialToInternet;

import java.math.BigInteger;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nuc.pojo.SensorData;
import com.nuc.service.SensorDataSevice;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

@Component
public class SerialListener implements SerialPortEventListener {

	/**
	 * 处理监控到的串口事件
	 */

	@Autowired
	SensorDataSevice sensorDataSevice;

	public static SerialListener serialListener;

	SensorData sensorData = new SensorData();
	private String Type, Data, Data1, Data2;
	private SerialPort serialPort;

	public SerialListener() {
	}

	@PostConstruct
	public void init() {
		serialListener = this;
		serialListener.sensorDataSevice = this.sensorDataSevice;
	}

	public SerialListener(SerialPort serialPort) {
		this.serialPort = serialPort;

	}

	public void serialEvent(SerialPortEvent serialPortEvent) {

		switch (serialPortEvent.getEventType()) {

		case SerialPortEvent.BI: // 10 通讯中断
			JOptionPane.showMessageDialog(null, "与串口设备通讯中断", "错误", JOptionPane.INFORMATION_MESSAGE);
			break;

		case SerialPortEvent.OE: // 7 溢位（溢出）错误

		case SerialPortEvent.FE: // 9 帧错误

		case SerialPortEvent.PE: // 8 奇偶校验错误

		case SerialPortEvent.CD: // 6 载波检测

		case SerialPortEvent.CTS: // 3 清除待发送数据

		case SerialPortEvent.DSR: // 4 待发送数据准备好了

		case SerialPortEvent.RI: // 5 振铃指示

		case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2 输出缓冲区已清空
			break;

		case SerialPortEvent.DATA_AVAILABLE: // 1 串口存在可用数据

			// System.out.println("found data");
			byte[] data = null;

			if (serialPort == null) {
				JOptionPane.showMessageDialog(null, "串口对象为空！监听失败！", "错误", JOptionPane.INFORMATION_MESSAGE);
			} else {
				data = SerialTool.readFromPort(serialPort); // 读取数据，存入字节数组
				String c = DatatypeConverter.printHexBinary(data);
				System.out.println(c);
				if (data == null || data.length < 1) { // 检查数据是否读取正确
					System.out.println("数据有误");
				} else {
					String temp = c.substring(10, 14);
					System.out.println(temp);
					switch (temp) {
					case SensorAddress.TEMPERATURE_AND_HUMIDITY:
						if (c.substring(14, 16).equals("01")) {
							Type = "温度";
							sensorData.setSensorId(2);
						} else {
							Type = "湿度";
							sensorData.setSensorId(3);
						}
						System.out.println(c.substring(14, 16));
						Data1 = c.substring(c.length() - 6, c.length() - 4);
						Data2 = c.substring(c.length() - 4, c.length() - 2);
						Data = Data2 + Data1;
						Data = new BigInteger(Data, 16).toString(10);
						Data = Data.substring(0, 2) + "." + Data.substring(2, 4);
						sensorData.setData(Float.valueOf(Data));
						break;
					case SensorAddress.LIGHT_SENSOR:
						Type = "光照";
						sensorData.setSensorId(4);
						Data = c.substring(c.length() - 6, c.length() - 2);
						sensorData.setData(Float.valueOf(Data));
						break;
					case SensorAddress.CONTROL_CENTER:
						Type = "控制器";
						sensorData.setSensorId(5);
						Data = c.substring(c.length() - 4, c.length() - 2);
						sensorData.setData(Float.valueOf(Data));
						break;
					case SensorAddress.RAINDROPS:
						Type = "雨滴";
						sensorData.setSensorId(1);
						Data = c.substring(c.length() - 4, c.length() - 2);
						sensorData.setData(Float.valueOf(Data));
						break;
					case SensorAddress.ROUTE:
						Type = "路由";
						sensorData.setSensorId(6);
						Data = c.substring(c.length() - 4, c.length() - 2);
						sensorData.setData(Float.valueOf(Data));
						break;
					}
					
					serialListener.sensorDataSevice.insertSelective(sensorData);	
					
					System.out.println("type:" + Type + "  data: " + Data);

				}

			}
			break;
		}

	}

}
