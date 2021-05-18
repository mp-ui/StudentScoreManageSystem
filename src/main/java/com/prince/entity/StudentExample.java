package com.prince.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSNoIsNull() {
            addCriterion("s_no is null");
            return (Criteria) this;
        }

        public Criteria andSNoIsNotNull() {
            addCriterion("s_no is not null");
            return (Criteria) this;
        }

        public Criteria andSNoEqualTo(String value) {
            addCriterion("s_no =", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoNotEqualTo(String value) {
            addCriterion("s_no <>", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoGreaterThan(String value) {
            addCriterion("s_no >", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoGreaterThanOrEqualTo(String value) {
            addCriterion("s_no >=", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoLessThan(String value) {
            addCriterion("s_no <", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoLessThanOrEqualTo(String value) {
            addCriterion("s_no <=", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoLike(String value) {
            addCriterion("s_no like", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoNotLike(String value) {
            addCriterion("s_no not like", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoIn(List<String> values) {
            addCriterion("s_no in", values, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoNotIn(List<String> values) {
            addCriterion("s_no not in", values, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoBetween(String value1, String value2) {
            addCriterion("s_no between", value1, value2, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoNotBetween(String value1, String value2) {
            addCriterion("s_no not between", value1, value2, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNameIsNull() {
            addCriterion("s_name is null");
            return (Criteria) this;
        }

        public Criteria andSNameIsNotNull() {
            addCriterion("s_name is not null");
            return (Criteria) this;
        }

        public Criteria andSNameEqualTo(String value) {
            addCriterion("s_name =", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotEqualTo(String value) {
            addCriterion("s_name <>", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThan(String value) {
            addCriterion("s_name >", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThanOrEqualTo(String value) {
            addCriterion("s_name >=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThan(String value) {
            addCriterion("s_name <", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThanOrEqualTo(String value) {
            addCriterion("s_name <=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLike(String value) {
            addCriterion("s_name like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotLike(String value) {
            addCriterion("s_name not like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameIn(List<String> values) {
            addCriterion("s_name in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotIn(List<String> values) {
            addCriterion("s_name not in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameBetween(String value1, String value2) {
            addCriterion("s_name between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotBetween(String value1, String value2) {
            addCriterion("s_name not between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSBirthdayIsNull() {
            addCriterion("s_birthday is null");
            return (Criteria) this;
        }

        public Criteria andSBirthdayIsNotNull() {
            addCriterion("s_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andSBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("s_birthday =", value, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("s_birthday <>", value, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("s_birthday >", value, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_birthday >=", value, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("s_birthday <", value, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_birthday <=", value, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("s_birthday in", values, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("s_birthday not in", values, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_birthday between", value1, value2, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_birthday not between", value1, value2, "sBirthday");
            return (Criteria) this;
        }

        public Criteria andSSexIsNull() {
            addCriterion("s_sex is null");
            return (Criteria) this;
        }

        public Criteria andSSexIsNotNull() {
            addCriterion("s_sex is not null");
            return (Criteria) this;
        }

        public Criteria andSSexEqualTo(Integer value) {
            addCriterion("s_sex =", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotEqualTo(Integer value) {
            addCriterion("s_sex <>", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexGreaterThan(Integer value) {
            addCriterion("s_sex >", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_sex >=", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLessThan(Integer value) {
            addCriterion("s_sex <", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLessThanOrEqualTo(Integer value) {
            addCriterion("s_sex <=", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexIn(List<Integer> values) {
            addCriterion("s_sex in", values, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotIn(List<Integer> values) {
            addCriterion("s_sex not in", values, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexBetween(Integer value1, Integer value2) {
            addCriterion("s_sex between", value1, value2, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotBetween(Integer value1, Integer value2) {
            addCriterion("s_sex not between", value1, value2, "sSex");
            return (Criteria) this;
        }

        public Criteria andSPasswordIsNull() {
            addCriterion("s_password is null");
            return (Criteria) this;
        }

        public Criteria andSPasswordIsNotNull() {
            addCriterion("s_password is not null");
            return (Criteria) this;
        }

        public Criteria andSPasswordEqualTo(String value) {
            addCriterion("s_password =", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordNotEqualTo(String value) {
            addCriterion("s_password <>", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordGreaterThan(String value) {
            addCriterion("s_password >", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("s_password >=", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordLessThan(String value) {
            addCriterion("s_password <", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordLessThanOrEqualTo(String value) {
            addCriterion("s_password <=", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordLike(String value) {
            addCriterion("s_password like", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordNotLike(String value) {
            addCriterion("s_password not like", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordIn(List<String> values) {
            addCriterion("s_password in", values, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordNotIn(List<String> values) {
            addCriterion("s_password not in", values, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordBetween(String value1, String value2) {
            addCriterion("s_password between", value1, value2, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordNotBetween(String value1, String value2) {
            addCriterion("s_password not between", value1, value2, "sPassword");
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