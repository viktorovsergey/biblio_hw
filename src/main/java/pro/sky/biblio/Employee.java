package pro.sky.biblio;

    import java.util.Objects;

    public class Employee {
        private String firstName;
        private String lastName;
        private Integer department;
        private Integer wage;

        public Employee(String lastName, String firstName, Integer department, Integer wage) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.department = department;
            this.wage = wage;
        }
        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public int getDepartment() {
            return department;
        }
        public int getWage() {
            return wage;
        }
        public void setFirstName(String firstName) {

            this.firstName = firstName;
        }

        public void setLastName(String lastName) {

            this.lastName = lastName;
        }

        public void getDepartment(Integer department) {

            this.department = department;
        }

        public void getWage(Integer wage) {

            this.wage = wage;
        }

        @Override
        public String toString() {
            return "Фамилия " + getLastName()
                    + " Имя " + getFirstName()
                    + "Департамент " + getDepartment()
                    + "Зарплата " + getWage();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }
    }

