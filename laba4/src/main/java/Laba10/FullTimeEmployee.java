package Laba10;



public class FullTimeEmployee extends Employee {
    private double premia;

    public FullTimeEmployee(String fio, String position, double oklad, double premia) throws Exception {
        super(fio, position, oklad);
        this.premia = premia;
    }

    public double getPremia() {
        return premia;
    }

    public void setPremia(double premia) {
        this.premia = premia;
    }

    @Override
    public double calculateSalary() {
        try {

            if (premia < 0) {
                throw new PremiyaException("Отрицательное значение премии", premia);
            }


            if (getOklad() <= 0) {
                throw new IllegalArgumentException("Оклад должен быть положительным числом");
            }

            double salary = getOklad() + premia;


            if (salary > 1_000_000) {
                throw new ArithmeticException("Зарплата превышает разумные пределы");
            }

            return salary;

        } catch (PremiyaException e) {
            System.err.println("Ошибка при расчете зарплаты: " + e.getMessage());
            return getOklad();
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при расчете зарплаты: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка при расчете зарплаты: " + e.getMessage());
            return 0;
        }
    }
}