package Laba10;

public class ContractEmployee extends Employee {
    private int contractDuration;

    public ContractEmployee(String fio, String position, double oklad, int contractDuration) throws Exception {
        super(fio, position, oklad);
        this.contractDuration = contractDuration;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    @Override
    public double calculateSalary() {
        try {

            if (getOklad() <= 0) {
                throw new IllegalArgumentException("Оклад должен быть положительным числом");
            }

            if (contractDuration <= 0) {
                throw new IllegalArgumentException("Длительность контракта должна быть положительной");
            }


            double salary = getOklad() * contractDuration;


            if (salary > 5_000_000) {
                throw new ArithmeticException("Суммарная зарплата за контракт превышает разумные пределы");
            }

            return salary;

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при расчете зарплаты по контракту: " + e.getMessage());
            return 0;
        } catch (ArithmeticException e) {
            System.err.println("Ошибка при расчете зарплаты по контракту: " + e.getMessage());
            return 5_000_000;
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка при расчете зарплаты по контракту: " + e.getMessage());
            return 0;
        }
    }
}