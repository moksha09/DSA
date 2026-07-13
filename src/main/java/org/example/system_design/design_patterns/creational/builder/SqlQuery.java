package org.example.system_design.design_patterns.creational.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SqlQuery {
    // A query builder that constructs SQL SELECT statements step-by-step.
    // This is a common pattern in ORMs and database libraries.

    private final String table;
    private final List<String> columns;
    private final List<String> conditions;
    private final String orderBy;
    private final String orderDirection;
    private final int limit;
    private final int offset;

    private SqlQuery(Builder builder){
        this.table = builder.table;;
        this.columns = Collections.unmodifiableList(new ArrayList<>(builder.columns));
        this.conditions = Collections.unmodifiableList(new ArrayList<>(builder.conditions));
        this.orderBy = builder.orderBy;
        this.orderDirection = builder.orderDirection;
        this.limit = builder.limit;
        this.offset = builder.offset;
    }

    public String toSql() {
        StringBuilder sql = new StringBuilder(" SELECT ");
        sql.append(columns.isEmpty() ? "*" : String.join(", ", columns));
        sql.append(" FROM ").append(table);
        if(!conditions.isEmpty()){
            sql.append(" WHERE ").append(String.join(" AND ", conditions));
        }
        if(orderBy!=null){
            sql.append(" ORDER BY ").append(orderBy).append(" ");
        }
        if(limit > 0){
            sql.append(" LIMIT ").append(limit).append(" ");
        }
        if(offset > 0){
            sql.append(" OFFSET ").append(offset).append(" ");
        }
        return sql.toString();
    }

    public static class Builder{
        private final String table;
        private List<String> columns = new ArrayList<>();
        private List<String> conditions = new ArrayList<>();
        private String orderBy;
        private String orderDirection = "ASC";
        private int limit;
        private int offset;

        public Builder(String table){
            this.table = table;
        }

        public Builder select(String... cols){
            this.columns.addAll(Arrays.asList(cols));
            return this;
        }

        public Builder where(String condition){
            this.conditions.add(condition);
            return this;
        }

        public Builder orderBy(String col, String direction){
            this.orderBy = col;
            this.orderDirection = direction;
            return this;
        }

        public Builder limit(int limit){
            this.limit = limit;
            return this;
        }

        public Builder offset(int offset){
            this.offset = offset;
            return this;
        }

        public SqlQuery build(){
            return new SqlQuery(this);
        }
    }

}
