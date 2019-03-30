package com.nuc.pojo;

import java.util.ArrayList;
import java.util.List;

public class SensorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SensorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSensorNameIsNull() {
            addCriterion("sensor_name is null");
            return (Criteria) this;
        }

        public Criteria andSensorNameIsNotNull() {
            addCriterion("sensor_name is not null");
            return (Criteria) this;
        }

        public Criteria andSensorNameEqualTo(String value) {
            addCriterion("sensor_name =", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotEqualTo(String value) {
            addCriterion("sensor_name <>", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameGreaterThan(String value) {
            addCriterion("sensor_name >", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_name >=", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameLessThan(String value) {
            addCriterion("sensor_name <", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameLessThanOrEqualTo(String value) {
            addCriterion("sensor_name <=", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameLike(String value) {
            addCriterion("sensor_name like", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotLike(String value) {
            addCriterion("sensor_name not like", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameIn(List<String> values) {
            addCriterion("sensor_name in", values, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotIn(List<String> values) {
            addCriterion("sensor_name not in", values, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameBetween(String value1, String value2) {
            addCriterion("sensor_name between", value1, value2, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotBetween(String value1, String value2) {
            addCriterion("sensor_name not between", value1, value2, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorAddressIsNull() {
            addCriterion("sensor_address is null");
            return (Criteria) this;
        }

        public Criteria andSensorAddressIsNotNull() {
            addCriterion("sensor_address is not null");
            return (Criteria) this;
        }

        public Criteria andSensorAddressEqualTo(String value) {
            addCriterion("sensor_address =", value, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressNotEqualTo(String value) {
            addCriterion("sensor_address <>", value, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressGreaterThan(String value) {
            addCriterion("sensor_address >", value, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_address >=", value, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressLessThan(String value) {
            addCriterion("sensor_address <", value, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressLessThanOrEqualTo(String value) {
            addCriterion("sensor_address <=", value, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressLike(String value) {
            addCriterion("sensor_address like", value, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressNotLike(String value) {
            addCriterion("sensor_address not like", value, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressIn(List<String> values) {
            addCriterion("sensor_address in", values, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressNotIn(List<String> values) {
            addCriterion("sensor_address not in", values, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressBetween(String value1, String value2) {
            addCriterion("sensor_address between", value1, value2, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andSensorAddressNotBetween(String value1, String value2) {
            addCriterion("sensor_address not between", value1, value2, "sensorAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressIsNull() {
            addCriterion("connect_address is null");
            return (Criteria) this;
        }

        public Criteria andConnectAddressIsNotNull() {
            addCriterion("connect_address is not null");
            return (Criteria) this;
        }

        public Criteria andConnectAddressEqualTo(String value) {
            addCriterion("connect_address =", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressNotEqualTo(String value) {
            addCriterion("connect_address <>", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressGreaterThan(String value) {
            addCriterion("connect_address >", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressGreaterThanOrEqualTo(String value) {
            addCriterion("connect_address >=", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressLessThan(String value) {
            addCriterion("connect_address <", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressLessThanOrEqualTo(String value) {
            addCriterion("connect_address <=", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressLike(String value) {
            addCriterion("connect_address like", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressNotLike(String value) {
            addCriterion("connect_address not like", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressIn(List<String> values) {
            addCriterion("connect_address in", values, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressNotIn(List<String> values) {
            addCriterion("connect_address not in", values, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressBetween(String value1, String value2) {
            addCriterion("connect_address between", value1, value2, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressNotBetween(String value1, String value2) {
            addCriterion("connect_address not between", value1, value2, "connectAddress");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}