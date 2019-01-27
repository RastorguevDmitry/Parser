

public class Employee {

    private String nomerPZ;
    private String empName;

    private String salary;
    private String nachalnayaMaxCenalota;
    private String srokIspolneniyaDogovora;

    public Employee(String nomerPZ, String empName,//
                    String salary, String nachalnayaMaxCenalota, String srokIspolneniyaDogovora) {
        this.nomerPZ = nomerPZ;
        this.empName = empName;
        this.salary = salary;
        this.nachalnayaMaxCenalota = nachalnayaMaxCenalota;
        this.srokIspolneniyaDogovora = srokIspolneniyaDogovora;
    }

    public String getEmpNo() {
        return nomerPZ;
    }

    public void setEmpNo(String nomerPZ) {
        this.nomerPZ = nomerPZ;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getNachalnayaMaxCenalota() {
        return nachalnayaMaxCenalota;
    }

    public void setNachalnayaMaxCenalota(String nachalnayaMaxCenalota) {
        this.nachalnayaMaxCenalota = nachalnayaMaxCenalota;
    }

    public String getSrokIspolneniyaDogovora() {
        return srokIspolneniyaDogovora;
    }

    public void setSrokIspolneniyaDogovora(String srokIspolneniyaDogovora) {
        this.srokIspolneniyaDogovora = srokIspolneniyaDogovora;
    }


}
