package com.car.dao.example;

import java.util.ArrayList;
import java.util.List;

public class CarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarExample() {
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

        public Criteria andSnoIsNull() {
            addCriterion("Sno is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("Sno is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(Integer value) {
            addCriterion("Sno =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(Integer value) {
            addCriterion("Sno <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(Integer value) {
            addCriterion("Sno >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Sno >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(Integer value) {
            addCriterion("Sno <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(Integer value) {
            addCriterion("Sno <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<Integer> values) {
            addCriterion("Sno in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<Integer> values) {
            addCriterion("Sno not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(Integer value1, Integer value2) {
            addCriterion("Sno between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(Integer value1, Integer value2) {
            addCriterion("Sno not between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andTnoIsNull() {
            addCriterion("Tno is null");
            return (Criteria) this;
        }

        public Criteria andTnoIsNotNull() {
            addCriterion("Tno is not null");
            return (Criteria) this;
        }

        public Criteria andTnoEqualTo(Integer value) {
            addCriterion("Tno =", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotEqualTo(Integer value) {
            addCriterion("Tno <>", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThan(Integer value) {
            addCriterion("Tno >", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Tno >=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThan(Integer value) {
            addCriterion("Tno <", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThanOrEqualTo(Integer value) {
            addCriterion("Tno <=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoIn(List<Integer> values) {
            addCriterion("Tno in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotIn(List<Integer> values) {
            addCriterion("Tno not in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoBetween(Integer value1, Integer value2) {
            addCriterion("Tno between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotBetween(Integer value1, Integer value2) {
            addCriterion("Tno not between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("Cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("Cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("Cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("Cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("Cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("Cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("Cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("Cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("Cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("Cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("Cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("Cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("Cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("Cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andClongIsNull() {
            addCriterion("Clong is null");
            return (Criteria) this;
        }

        public Criteria andClongIsNotNull() {
            addCriterion("Clong is not null");
            return (Criteria) this;
        }

        public Criteria andClongEqualTo(String value) {
            addCriterion("Clong =", value, "clong");
            return (Criteria) this;
        }

        public Criteria andClongNotEqualTo(String value) {
            addCriterion("Clong <>", value, "clong");
            return (Criteria) this;
        }

        public Criteria andClongGreaterThan(String value) {
            addCriterion("Clong >", value, "clong");
            return (Criteria) this;
        }

        public Criteria andClongGreaterThanOrEqualTo(String value) {
            addCriterion("Clong >=", value, "clong");
            return (Criteria) this;
        }

        public Criteria andClongLessThan(String value) {
            addCriterion("Clong <", value, "clong");
            return (Criteria) this;
        }

        public Criteria andClongLessThanOrEqualTo(String value) {
            addCriterion("Clong <=", value, "clong");
            return (Criteria) this;
        }

        public Criteria andClongLike(String value) {
            addCriterion("Clong like", value, "clong");
            return (Criteria) this;
        }

        public Criteria andClongNotLike(String value) {
            addCriterion("Clong not like", value, "clong");
            return (Criteria) this;
        }

        public Criteria andClongIn(List<String> values) {
            addCriterion("Clong in", values, "clong");
            return (Criteria) this;
        }

        public Criteria andClongNotIn(List<String> values) {
            addCriterion("Clong not in", values, "clong");
            return (Criteria) this;
        }

        public Criteria andClongBetween(String value1, String value2) {
            addCriterion("Clong between", value1, value2, "clong");
            return (Criteria) this;
        }

        public Criteria andClongNotBetween(String value1, String value2) {
            addCriterion("Clong not between", value1, value2, "clong");
            return (Criteria) this;
        }

        public Criteria andCpictureIsNull() {
            addCriterion("Cpicture is null");
            return (Criteria) this;
        }

        public Criteria andCpictureIsNotNull() {
            addCriterion("Cpicture is not null");
            return (Criteria) this;
        }

        public Criteria andCpictureEqualTo(String value) {
            addCriterion("Cpicture =", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureNotEqualTo(String value) {
            addCriterion("Cpicture <>", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureGreaterThan(String value) {
            addCriterion("Cpicture >", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureGreaterThanOrEqualTo(String value) {
            addCriterion("Cpicture >=", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureLessThan(String value) {
            addCriterion("Cpicture <", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureLessThanOrEqualTo(String value) {
            addCriterion("Cpicture <=", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureLike(String value) {
            addCriterion("Cpicture like", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureNotLike(String value) {
            addCriterion("Cpicture not like", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureIn(List<String> values) {
            addCriterion("Cpicture in", values, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureNotIn(List<String> values) {
            addCriterion("Cpicture not in", values, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureBetween(String value1, String value2) {
            addCriterion("Cpicture between", value1, value2, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureNotBetween(String value1, String value2) {
            addCriterion("Cpicture not between", value1, value2, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCstateIsNull() {
            addCriterion("Cstate is null");
            return (Criteria) this;
        }

        public Criteria andCstateIsNotNull() {
            addCriterion("Cstate is not null");
            return (Criteria) this;
        }

        public Criteria andCstateEqualTo(Integer value) {
            addCriterion("Cstate =", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateNotEqualTo(Integer value) {
            addCriterion("Cstate <>", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateGreaterThan(Integer value) {
            addCriterion("Cstate >", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cstate >=", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateLessThan(Integer value) {
            addCriterion("Cstate <", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateLessThanOrEqualTo(Integer value) {
            addCriterion("Cstate <=", value, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateIn(List<Integer> values) {
            addCriterion("Cstate in", values, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateNotIn(List<Integer> values) {
            addCriterion("Cstate not in", values, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateBetween(Integer value1, Integer value2) {
            addCriterion("Cstate between", value1, value2, "cstate");
            return (Criteria) this;
        }

        public Criteria andCstateNotBetween(Integer value1, Integer value2) {
            addCriterion("Cstate not between", value1, value2, "cstate");
            return (Criteria) this;
        }

        public Criteria andCpriceIsNull() {
            addCriterion("Cprice is null");
            return (Criteria) this;
        }

        public Criteria andCpriceIsNotNull() {
            addCriterion("Cprice is not null");
            return (Criteria) this;
        }

        public Criteria andCpriceEqualTo(Float value) {
            addCriterion("Cprice =", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceNotEqualTo(Float value) {
            addCriterion("Cprice <>", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceGreaterThan(Float value) {
            addCriterion("Cprice >", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("Cprice >=", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceLessThan(Float value) {
            addCriterion("Cprice <", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceLessThanOrEqualTo(Float value) {
            addCriterion("Cprice <=", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceIn(List<Float> values) {
            addCriterion("Cprice in", values, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceNotIn(List<Float> values) {
            addCriterion("Cprice not in", values, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceBetween(Float value1, Float value2) {
            addCriterion("Cprice between", value1, value2, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceNotBetween(Float value1, Float value2) {
            addCriterion("Cprice not between", value1, value2, "cprice");
            return (Criteria) this;
        }

        public Criteria andClookIsNull() {
            addCriterion("Clook is null");
            return (Criteria) this;
        }

        public Criteria andClookIsNotNull() {
            addCriterion("Clook is not null");
            return (Criteria) this;
        }

        public Criteria andClookEqualTo(Integer value) {
            addCriterion("Clook =", value, "clook");
            return (Criteria) this;
        }

        public Criteria andClookNotEqualTo(Integer value) {
            addCriterion("Clook <>", value, "clook");
            return (Criteria) this;
        }

        public Criteria andClookGreaterThan(Integer value) {
            addCriterion("Clook >", value, "clook");
            return (Criteria) this;
        }

        public Criteria andClookGreaterThanOrEqualTo(Integer value) {
            addCriterion("Clook >=", value, "clook");
            return (Criteria) this;
        }

        public Criteria andClookLessThan(Integer value) {
            addCriterion("Clook <", value, "clook");
            return (Criteria) this;
        }

        public Criteria andClookLessThanOrEqualTo(Integer value) {
            addCriterion("Clook <=", value, "clook");
            return (Criteria) this;
        }

        public Criteria andClookIn(List<Integer> values) {
            addCriterion("Clook in", values, "clook");
            return (Criteria) this;
        }

        public Criteria andClookNotIn(List<Integer> values) {
            addCriterion("Clook not in", values, "clook");
            return (Criteria) this;
        }

        public Criteria andClookBetween(Integer value1, Integer value2) {
            addCriterion("Clook between", value1, value2, "clook");
            return (Criteria) this;
        }

        public Criteria andClookNotBetween(Integer value1, Integer value2) {
            addCriterion("Clook not between", value1, value2, "clook");
            return (Criteria) this;
        }

        public Criteria andCgoodIsNull() {
            addCriterion("Cgood is null");
            return (Criteria) this;
        }

        public Criteria andCgoodIsNotNull() {
            addCriterion("Cgood is not null");
            return (Criteria) this;
        }

        public Criteria andCgoodEqualTo(Integer value) {
            addCriterion("Cgood =", value, "cgood");
            return (Criteria) this;
        }

        public Criteria andCgoodNotEqualTo(Integer value) {
            addCriterion("Cgood <>", value, "cgood");
            return (Criteria) this;
        }

        public Criteria andCgoodGreaterThan(Integer value) {
            addCriterion("Cgood >", value, "cgood");
            return (Criteria) this;
        }

        public Criteria andCgoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cgood >=", value, "cgood");
            return (Criteria) this;
        }

        public Criteria andCgoodLessThan(Integer value) {
            addCriterion("Cgood <", value, "cgood");
            return (Criteria) this;
        }

        public Criteria andCgoodLessThanOrEqualTo(Integer value) {
            addCriterion("Cgood <=", value, "cgood");
            return (Criteria) this;
        }

        public Criteria andCgoodIn(List<Integer> values) {
            addCriterion("Cgood in", values, "cgood");
            return (Criteria) this;
        }

        public Criteria andCgoodNotIn(List<Integer> values) {
            addCriterion("Cgood not in", values, "cgood");
            return (Criteria) this;
        }

        public Criteria andCgoodBetween(Integer value1, Integer value2) {
            addCriterion("Cgood between", value1, value2, "cgood");
            return (Criteria) this;
        }

        public Criteria andCgoodNotBetween(Integer value1, Integer value2) {
            addCriterion("Cgood not between", value1, value2, "cgood");
            return (Criteria) this;
        }

        public Criteria andCbadIsNull() {
            addCriterion("Cbad is null");
            return (Criteria) this;
        }

        public Criteria andCbadIsNotNull() {
            addCriterion("Cbad is not null");
            return (Criteria) this;
        }

        public Criteria andCbadEqualTo(Integer value) {
            addCriterion("Cbad =", value, "cbad");
            return (Criteria) this;
        }

        public Criteria andCbadNotEqualTo(Integer value) {
            addCriterion("Cbad <>", value, "cbad");
            return (Criteria) this;
        }

        public Criteria andCbadGreaterThan(Integer value) {
            addCriterion("Cbad >", value, "cbad");
            return (Criteria) this;
        }

        public Criteria andCbadGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cbad >=", value, "cbad");
            return (Criteria) this;
        }

        public Criteria andCbadLessThan(Integer value) {
            addCriterion("Cbad <", value, "cbad");
            return (Criteria) this;
        }

        public Criteria andCbadLessThanOrEqualTo(Integer value) {
            addCriterion("Cbad <=", value, "cbad");
            return (Criteria) this;
        }

        public Criteria andCbadIn(List<Integer> values) {
            addCriterion("Cbad in", values, "cbad");
            return (Criteria) this;
        }

        public Criteria andCbadNotIn(List<Integer> values) {
            addCriterion("Cbad not in", values, "cbad");
            return (Criteria) this;
        }

        public Criteria andCbadBetween(Integer value1, Integer value2) {
            addCriterion("Cbad between", value1, value2, "cbad");
            return (Criteria) this;
        }

        public Criteria andCbadNotBetween(Integer value1, Integer value2) {
            addCriterion("Cbad not between", value1, value2, "cbad");
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