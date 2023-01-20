package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.isNull;

public class Service {
    public List<String> processChristmasTrees(List<String> data, int newOrnamentsToAdd) {

        Map <Integer, Value> dataSet = new HashMap<>();

        for (String instruction: data) {

            String[] instSet = instruction.split(" ");
            int id = Integer.parseInt(instSet[0]);
            int count = Integer.parseInt(instSet[1]);
            String operation = instSet[2];
            switch (operation) {
                case "used_ornaments" -> {
                    if (dataSet.containsKey(id)) {
                        Value value = dataSet.get(id);
                        value.setUsed(count);
                        value.setRemSpace(value.getMaxCap() - count);
                        dataSet.put(id, value);
                    } else {
                        Value value = new Value(count, null, null);
                        dataSet.put(id, value);
                    }

                }
                case "max_capacity" -> {
                    if (dataSet.containsKey(id)) {
                        Value value = dataSet.get(id);
                        value.setMaxCap(count);
                        value.setRemSpace(count - value.getUsed());
                        dataSet.put(id, value);
                    } else {
                        Value value = new Value(null, count, null);
                        dataSet.put(id, value);
                    }
                }
                default -> System.out.println("Error"); //throw new RuntimeException("Wrong operation");
            }
        }

        return dataSet.entrySet().stream()
                .filter(i -> i.getValue().getRemSpace() != null)
                .filter(i -> i.getValue().getRemSpace() <= newOrnamentsToAdd)
                .map(o -> o.getKey().toString()).sorted().toList();
    }



    class Value {
        private Integer used;
        private Integer maxCapacity;
        private Integer remainingSpace;

        public Value(Integer used, Integer maxCapacity, Integer remainingSpace) {
            this.used = used;
            this.maxCapacity = maxCapacity;
            this.remainingSpace = remainingSpace;
        }

        public Integer getUsed() {
            return isNull(used)? 0 : used;
        }

        public void setUsed(Integer used) {
            this.used = used;
        }

        public Integer getMaxCap() {
            return isNull(maxCapacity) ? 0: maxCapacity;
        }

        public void setMaxCap(Integer maxCap) {
            this.maxCapacity = maxCap;
        }

        public Integer getRemSpace() {
            return isNull(remainingSpace) ? null: remainingSpace;
        }

        public void setRemSpace(Integer remSpace) {
            this.remainingSpace = remSpace;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Value value = (Value) o;
            return Objects.equals(used, value.used) && Objects.equals(maxCapacity, value.maxCapacity) && Objects.equals(remainingSpace, value.remainingSpace);
        }

        @Override
        public int hashCode() {
            return Objects.hash(used, maxCapacity, remainingSpace);
        }
    }
}
