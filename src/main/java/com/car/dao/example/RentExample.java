package com.car.dao.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentExample() {
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

        public Criteria andRnoIsNull() {
            addCriterion("Rno is null");
            return (Criteria) this;
        }

        public Criteria andRnoIsNotNull() {
            addCriterion("Rno is not null");
            return (Criteria) this;
        }

        public Criteria andRnoEqualTo(Integer value) {
            addCriterion("Rno =", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoNotEqualTo(Integer value) {
            addCriterion("Rno <>", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoGreaterThan(Integer value) {
            addCriterion("Rno >", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Rno >=", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoLessThan(Integer value) {
            addCriterion("Rno <", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoLessThanOrEqualTo(Integer value) {
            addCriterion("Rno <=", value, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoIn(List<Integer> values) {
            addCriterion("Rno in", values, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoNotIn(List<Integer> values) {
            addCriterion("Rno not in", values, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoBetween(Integer value1, Integer value2) {
            addCriterion("Rno between", value1, value2, "rno");
            return (Criteria) this;
        }

        public Criteria andRnoNotBetween(Integer value1, Integer value2) {
            addCriterion("Rno not between", value1, value2, "rno");
            return (Criteria) this;
        }

        public Criteria andCnoIsNull() {
            addCriterion("Cno is null");
            return (Criteria) this;
        }

        public Criteria andCnoIsNotNull() {
            addCriterion("Cno is not null");
            return (Criteria) this;
        }

        public Criteria andCnoEqualTo(Integer value) {
            addCriterion("Cno =", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotEqualTo(Integer value) {
            addCriterion("Cno <>", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThan(Integer value) {
            addCriterion("Cno >", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cno >=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThan(Integer value) {
            addCriterion("Cno <", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThanOrEqualTo(Integer value) {
            addCriterion("Cno <=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoIn(List<Integer> values) {
            addCriterion("Cno in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotIn(List<Integer> values) {
            addCriterion("Cno not in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoBetween(Integer value1, Integer value2) {
            addCriterion("Cno between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotBetween(Integer value1, Integer value2) {
            addCriterion("Cno not between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andUcodeIsNull() {
            addCriterion("Ucode is null");
            return (Criteria) this;
        }

        public Criteria andUcodeIsNotNull() {
            addCriterion("Ucode is not null");
            return (Criteria) this;
        }

        public Criteria andUcodeEqualTo(Integer value) {
            addCriterion("Ucode =", value, "ucode");
            return (Criteria) this;
        }

        public Criteria andUcodeNotEqualTo(Integer value) {
            addCriterion("Ucode <>", value, "ucode");
            return (Criteria) this;
        }

        public Criteria andUcodeGreaterThan(Integer value) {
            addCriterion("Ucode >", value, "ucode");
            return (Criteria) this;
        }

        public Criteria andUcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Ucode >=", value, "ucode");
            return (Criteria) this;
        }

        public Criteria andUcodeLessThan(Integer value) {
            addCriterion("Ucode <", value, "ucode");
            return (Criteria) this;
        }

        public Criteria andUcodeLessThanOrEqualTo(Integer value) {
            addCriterion("Ucode <=", value, "ucode");
            return (Criteria) this;
        }

        public Criteria andUcodeIn(List<Integer> values) {
            addCriterion("Ucode in", values, "ucode");
            return (Criteria) this;
        }

        public Criteria andUcodeNotIn(List<Integer> values) {
            addCriterion("Ucode not in", values, "ucode");
            return (Criteria) this;
        }

        public Criteria andUcodeBetween(Integer value1, Integer value2) {
            addCriterion("Ucode between", value1, value2, "ucode");
            return (Criteria) this;
        }

        public Criteria andUcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("Ucode not between", value1, value2, "ucode");
            return (Criteria) this;
        }

        public Criteria andRlendIsNull() {
            addCriterion("Rlend is null");
            return (Criteria) this;
        }

        public Criteria andRlendIsNotNull() {
            addCriterion("Rlend is not null");
            return (Criteria) this;
        }

        public Criteria andRlendEqualTo(Date value) {
            addCriterion("Rlend =", value, "rlend");
            return (Criteria) this;
        }

        public Criteria andRlendNotEqualTo(Date value) {
            addCriterion("Rlend <>", value, "rlend");
            return (Criteria) this;
        }

        public Criteria andRlendGreaterThan(Date value) {
            addCriterion("Rlend >", value, "rlend");
            return (Criteria) this;
        }

        public Criteria andRlendGreaterThanOrEqualTo(Date value) {
            addCriterion("Rlend >=", value, "rlend");
            return (Criteria) this;
        }

        public Criteria andRlendLessThan(Date value) {
            addCriterion("Rlend <", value, "rlend");
            return (Criteria) this;
        }

        public Criteria andRlendLessThanOrEqualTo(Date value) {
            addCriterion("Rlend <=", value, "rlend");
            return (Criteria) this;
        }

        public Criteria andRlendIn(List<Date> values) {
            addCriterion("Rlend in", values, "rlend");
            return (Criteria) this;
        }

        public Criteria andRlendNotIn(List<Date> values) {
            addCriterion("Rlend not in", values, "rlend");
            return (Criteria) this;
        }

        public Criteria andRlendBetween(Date value1, Date value2) {
            addCriterion("Rlend between", value1, value2, "rlend");
            return (Criteria) this;
        }

        public Criteria andRlendNotBetween(Date value1, Date value2) {
            addCriterion("Rlend not between", value1, value2, "rlend");
            return (Criteria) this;
        }

        public Criteria andRreturnIsNull() {
            addCriterion("Rreturn is null");
            return (Criteria) this;
        }

        public Criteria andRreturnIsNotNull() {
            addCriterion("Rreturn is not null");
            return (Criteria) this;
        }

        public Criteria andRreturnEqualTo(Date value) {
            addCriterion("Rreturn =", value, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRreturnNotEqualTo(Date value) {
            addCriterion("Rreturn <>", value, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRreturnGreaterThan(Date value) {
            addCriterion("Rreturn >", value, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRreturnGreaterThanOrEqualTo(Date value) {
            addCriterion("Rreturn >=", value, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRreturnLessThan(Date value) {
            addCriterion("Rreturn <", value, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRreturnLessThanOrEqualTo(Date value) {
            addCriterion("Rreturn <=", value, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRreturnIn(List<Date> values) {
            addCriterion("Rreturn in", values, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRreturnNotIn(List<Date> values) {
            addCriterion("Rreturn not in", values, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRreturnBetween(Date value1, Date value2) {
            addCriterion("Rreturn between", value1, value2, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRreturnNotBetween(Date value1, Date value2) {
            addCriterion("Rreturn not between", value1, value2, "rreturn");
            return (Criteria) this;
        }

        public Criteria andRpriceIsNull() {
            addCriterion("Rprice is null");
            return (Criteria) this;
        }

        public Criteria andRpriceIsNotNull() {
            addCriterion("Rprice is not null");
            return (Criteria) this;
        }

        public Criteria andRpriceEqualTo(Float value) {
            addCriterion("Rprice =", value, "rprice");
            return (Criteria) this;
        }

        public Criteria andRpriceNotEqualTo(Float value) {
            addCriterion("Rprice <>", value, "rprice");
            return (Criteria) this;
        }

        public Criteria andRpriceGreaterThan(Float value) {
            addCriterion("Rprice >", value, "rprice");
            return (Criteria) this;
        }

        public Criteria andRpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("Rprice >=", value, "rprice");
            return (Criteria) this;
        }

        public Criteria andRpriceLessThan(Float value) {
            addCriterion("Rprice <", value, "rprice");
            return (Criteria) this;
        }

        public Criteria andRpriceLessThanOrEqualTo(Float value) {
            addCriterion("Rprice <=", value, "rprice");
            return (Criteria) this;
        }

        public Criteria andRpriceIn(List<Float> values) {
            addCriterion("Rprice in", values, "rprice");
            return (Criteria) this;
        }

        public Criteria andRpriceNotIn(List<Float> values) {
            addCriterion("Rprice not in", values, "rprice");
            return (Criteria) this;
        }

        public Criteria andRpriceBetween(Float value1, Float value2) {
            addCriterion("Rprice between", value1, value2, "rprice");
            return (Criteria) this;
        }

        public Criteria andRpriceNotBetween(Float value1, Float value2) {
            addCriterion("Rprice not between", value1, value2, "rprice");
            return (Criteria) this;
        }

        public Criteria andRstateIsNull() {
            addCriterion("Rstate is null");
            return (Criteria) this;
        }

        public Criteria andRstateIsNotNull() {
            addCriterion("Rstate is not null");
            return (Criteria) this;
        }

        public Criteria andRstateEqualTo(Integer value) {
            addCriterion("Rstate =", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotEqualTo(Integer value) {
            addCriterion("Rstate <>", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateGreaterThan(Integer value) {
            addCriterion("Rstate >", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("Rstate >=", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateLessThan(Integer value) {
            addCriterion("Rstate <", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateLessThanOrEqualTo(Integer value) {
            addCriterion("Rstate <=", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateIn(List<Integer> values) {
            addCriterion("Rstate in", values, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotIn(List<Integer> values) {
            addCriterion("Rstate not in", values, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateBetween(Integer value1, Integer value2) {
            addCriterion("Rstate between", value1, value2, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotBetween(Integer value1, Integer value2) {
            addCriterion("Rstate not between", value1, value2, "rstate");
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