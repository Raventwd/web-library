package ru.skypro.lessons.springboot.weblibrary.dto;

public class ReportDto {
    private String name;
    private Long count;
    private int minSalary;
    private int maxSalary;
    private double avgSalary;

    public ReportDto(String name, Long count, int minSalary, int maxSalary, double avgSalary) {
        this.name = name;
        this.count = count;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.avgSalary = avgSalary;
    }

    public String getPositionName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                ", avgSalary=" + avgSalary +
                '}';
    }
}
