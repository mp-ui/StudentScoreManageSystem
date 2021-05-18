package com.prince.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTNoIsNull() {
            addCriterion("t_no is null");
            return (Criteria) this;
        }

        public Criteria andTNoIsNotNull() {
            addCriterion("t_no is not null");
            return (Criteria) this;
        }

        public Criteria andTNoEqualTo(String value) {
            addCriterion("t_no =", value, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoNotEqualTo(String value) {
            addCriterion("t_no <>", value, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoGreaterThan(String value) {
            addCriterion("t_no >", value, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoGreaterThanOrEqualTo(String value) {
            addCriterion("t_no >=", value, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoLessThan(String value) {
            addCriterion("t_no <", value, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoLessThanOrEqualTo(String value) {
            addCriterion("t_no <=", value, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoLike(String value) {
            addCriterion("t_no like", value, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoNotLike(String value) {
            addCriterion("t_no not like", value, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoIn(List<String> values) {
            addCriterion("t_no in", values, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoNotIn(List<String> values) {
            addCriterion("t_no not in", values, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoBetween(String value1, String value2) {
            addCriterion("t_no between", value1, value2, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNoNotBetween(String value1, String value2) {
            addCriterion("t_no not between", value1, value2, "tNo");
            return (Criteria) this;
        }

        public Criteria andTNameIsNull() {
            addCriterion("t_name is null");
            return (Criteria) this;
        }

        public Criteria andTNameIsNotNull() {
            addCriterion("t_name is not null");
            return (Criteria) this;
        }

        public Criteria andTNameEqualTo(String value) {
            addCriterion("t_name =", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotEqualTo(String value) {
            addCriterion("t_name <>", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThan(String value) {
            addCriterion("t_name >", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_name >=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThan(String value) {
            addCriterion("t_name <", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThanOrEqualTo(String value) {
            addCriterion("t_name <=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLike(String value) {
            addCriterion("t_name like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotLike(String value) {
            addCriterion("t_name not like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameIn(List<String> values) {
            addCriterion("t_name in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotIn(List<String> values) {
            addCriterion("t_name not in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameBetween(String value1, String value2) {
            addCriterion("t_name between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotBetween(String value1, String value2) {
            addCriterion("t_name not between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTPositionIsNull() {
            addCriterion("t_position is null");
            return (Criteria) this;
        }

        public Criteria andTPositionIsNotNull() {
            addCriterion("t_position is not null");
            return (Criteria) this;
        }

        public Criteria andTPositionEqualTo(String value) {
            addCriterion("t_position =", value, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionNotEqualTo(String value) {
            addCriterion("t_position <>", value, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionGreaterThan(String value) {
            addCriterion("t_position >", value, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionGreaterThanOrEqualTo(String value) {
            addCriterion("t_position >=", value, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionLessThan(String value) {
            addCriterion("t_position <", value, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionLessThanOrEqualTo(String value) {
            addCriterion("t_position <=", value, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionLike(String value) {
            addCriterion("t_position like", value, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionNotLike(String value) {
            addCriterion("t_position not like", value, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionIn(List<String> values) {
            addCriterion("t_position in", values, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionNotIn(List<String> values) {
            addCriterion("t_position not in", values, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionBetween(String value1, String value2) {
            addCriterion("t_position between", value1, value2, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTPositionNotBetween(String value1, String value2) {
            addCriterion("t_position not between", value1, value2, "tPosition");
            return (Criteria) this;
        }

        public Criteria andTBirthdayIsNull() {
            addCriterion("t_birthday is null");
            return (Criteria) this;
        }

        public Criteria andTBirthdayIsNotNull() {
            addCriterion("t_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andTBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("t_birthday =", value, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("t_birthday <>", value, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("t_birthday >", value, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_birthday >=", value, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("t_birthday <", value, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_birthday <=", value, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("t_birthday in", values, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("t_birthday not in", values, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_birthday between", value1, value2, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_birthday not between", value1, value2, "tBirthday");
            return (Criteria) this;
        }

        public Criteria andTSexIsNull() {
            addCriterion("t_sex is null");
            return (Criteria) this;
        }

        public Criteria andTSexIsNotNull() {
            addCriterion("t_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTSexEqualTo(Integer value) {
            addCriterion("t_sex =", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotEqualTo(Integer value) {
            addCriterion("t_sex <>", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexGreaterThan(Integer value) {
            addCriterion("t_sex >", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_sex >=", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexLessThan(Integer value) {
            addCriterion("t_sex <", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexLessThanOrEqualTo(Integer value) {
            addCriterion("t_sex <=", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexIn(List<Integer> values) {
            addCriterion("t_sex in", values, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotIn(List<Integer> values) {
            addCriterion("t_sex not in", values, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexBetween(Integer value1, Integer value2) {
            addCriterion("t_sex between", value1, value2, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotBetween(Integer value1, Integer value2) {
            addCriterion("t_sex not between", value1, value2, "tSex");
            return (Criteria) this;
        }

        public Criteria andTPasswordIsNull() {
            addCriterion("t_password is null");
            return (Criteria) this;
        }

        public Criteria andTPasswordIsNotNull() {
            addCriterion("t_password is not null");
            return (Criteria) this;
        }

        public Criteria andTPasswordEqualTo(String value) {
            addCriterion("t_password =", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordNotEqualTo(String value) {
            addCriterion("t_password <>", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordGreaterThan(String value) {
            addCriterion("t_password >", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("t_password >=", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordLessThan(String value) {
            addCriterion("t_password <", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordLessThanOrEqualTo(String value) {
            addCriterion("t_password <=", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordLike(String value) {
            addCriterion("t_password like", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordNotLike(String value) {
            addCriterion("t_password not like", value, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordIn(List<String> values) {
            addCriterion("t_password in", values, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordNotIn(List<String> values) {
            addCriterion("t_password not in", values, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordBetween(String value1, String value2) {
            addCriterion("t_password between", value1, value2, "tPassword");
            return (Criteria) this;
        }

        public Criteria andTPasswordNotBetween(String value1, String value2) {
            addCriterion("t_password not between", value1, value2, "tPassword");
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