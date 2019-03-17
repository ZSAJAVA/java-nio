package cn.xc.javaHomework;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/16 - 21:33
 */
public class Student {

    private String sno;
    private String sname;
    private Integer yuwen;
    private Integer shuxue;
    private Integer yingyu;
    private Integer countGrade;
    private Integer avgGrade;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getYuwen() {
        return yuwen;
    }

    public void setYuwen(Integer yuwen) {
        this.yuwen = yuwen;
    }

    public Integer getShuxue() {
        return shuxue;
    }

    public void setShuxue(Integer shuxue) {
        this.shuxue = shuxue;
    }

    public Integer getYingyu() {
        return yingyu;
    }

    public void setYingyu(Integer yingyu) {
        this.yingyu = yingyu;
    }

    public Integer getCountGrade() {
        return countGrade;
    }

    public void setCountGrade(Integer countGrade) {
        this.countGrade = countGrade;
    }

    public Integer getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Integer avgGrade) {
        this.avgGrade = avgGrade;
    }
}
