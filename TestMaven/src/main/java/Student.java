
    public class Student {
        private String name;
        private int age;
        private String university;
        private String batch;
        private double psp;
        private String email;

        private Student(Builder b) {
            // validate(b);
            this.psp = b.psp;
            this.name = b.name;
            this.age = b.age;
            this.university = b.university;
            this.batch =b.batch;
            this.email = b.email;
            // .....
        }

        public static Builder getBuilder() {
            return new Builder();
        }

        public static class Builder {
            private String name;
            private int age;
            private String university;
            private String batch;
            private double psp;
            private String email;

            public  Builder setName(String name) {
                this.name = name;
                return this;
            }

            public Builder setAge(int age) {
                this.age = age;
                return this;
            }

            public Builder setUniversity(String university) {
                this.university = university;
                return this;
            }

            public Builder setBatch(String batch) {
                this.batch = batch;
                return this;
            }

            public Builder setPsp(double psp) {
                this.psp = psp;
                return this;
            }

            public Builder setEmail(String email) {
                this.email = email;
                return this;
            }

            boolean validate() {
                if (this.age < 18) {
                    return false;
                }

                if (2000 + this.age > 2055) {
                    return false;
                }

                return true;
            }
            public Student build() {
                if (!validate()) {
                    throw  new RuntimeException();
                }
                return new Student(this);
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", university='" + university + '\'' +
                    ", batch='" + batch + '\'' +
                    ", psp=" + psp +
                    ", email='" + email + '\'' +
                    '}';
        }
    }


