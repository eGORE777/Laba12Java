package Laba10;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы предприятия ===");


        Company company = new Company("");
        Department itDepartment = new Department("IT отдел");
        Department hrDepartment = new Department("HR отдел");

        company.addDepartment(itDepartment);
        company.addDepartment(hrDepartment);


        System.out.println("\n=== Тест обработки OkladException в конструкторе ===");

        try {

            Employee invalidEmployee = new FullTimeEmployee(
                    "Иванов Иван", "Разработчик", -50000, 10000
            );
        } catch (OkladException e) {
            System.err.println("Поймано исключение: " + e.getMessage());


            try {
                throw new OkladException("Повторное исключение после обработки", -50000);
            } catch (OkladException ex) {
                System.err.println("Повторно поймано исключение: " + ex.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Общее исключение: " + e.getMessage());
        }


        System.out.println("\n=== Создание корректных сотрудников ===");

        try {

            FullTimeEmployee employee1 = new FullTimeEmployee(
                    "Петров Петр", "Senior Developer", 150000, 30000
            );
            itDepartment.addEmployee(employee1);

            FullTimeEmployee employee2 = new FullTimeEmployee(
                    "Сидорова Анна", "HR Manager", 80000, 15000
            );
            hrDepartment.addEmployee(employee2);


            ContractEmployee contractor = new ContractEmployee(
                    "Кузнецов Алексей", "Project Manager", 120000, 6
            );
            itDepartment.addEmployee(contractor);


            System.out.println("\n=== Расчет зарплат ===");
            demonstrateSalaryCalculation(employee1, employee2, contractor);


            System.out.println("\n=== Тест с отрицательной премией ===");
            testNegativePremia();


            System.out.println("\n=== Тест с некорректным контрактом ===");
            testInvalidContract();

        } catch (Exception e) {
            System.err.println("Ошибка при создании сотрудников: " + e.getMessage());
        }

        System.out.println("\n=== Программа завершена ===");
    }

    private static void demonstrateSalaryCalculation(FullTimeEmployee emp1,
                                                     FullTimeEmployee emp2,
                                                     ContractEmployee contractor) {

        System.out.println("Зарплата " + emp1.getFio() + ": " + emp1.calculateSalary());
        System.out.println("Зарплата " + emp2.getFio() + ": " + emp2.calculateSalary());


        System.out.println("Зарплата по контракту " + contractor.getFio() + ": " + contractor.calculateSalary());
    }

    private static void testNegativePremia() {
        try {
            FullTimeEmployee badEmployee = new FullTimeEmployee(
                    "Тестовый Сотрудник", "Tester", 50000, -10000
            );


            double salary = badEmployee.calculateSalary();
            System.out.println("Результат расчета с отрицательной премией: " + salary);

        } catch (Exception e) {
            System.err.println("Ошибка при создании тестового сотрудника: " + e.getMessage());
        }
    }

    private static void testInvalidContract() {
        try {
            ContractEmployee badContractor = new ContractEmployee(
                    "Неверный Контракт", "Consultant", 100000, -5
            );

            double salary = badContractor.calculateSalary();
            System.out.println("Результат расчета с неверным контрактом: " + salary);

        } catch (Exception e) {
            System.err.println("Ошибка при создании контрактного сотрудника: " + e.getMessage());
        }
    }
}