public class User {

        private String username;
        private int password;
        private int type;
        private String holdid;
        private int antalkørtekilometer;
        private int antalkørtedage;


        public User(String username, int password, int type, String holdid, int antalkørtekilometer, int antalkørtedage){
            this.username=username;
            this.password=password;
            this.type=type;
            this.holdid=holdid;
            this.antalkørtekilometer=antalkørtekilometer;
            this.antalkørtedage=antalkørtedage;

        }

        public String getUsername(){ return username; }
        public void setUsername(){ this.username=username; }


        public int getPassword(){ return password; }
        public void setPassword(){ this.password=password; }


        public int getType(){ return type ;}
        public void setType(){ this.type=type; }


        public String getHoldid(){ return holdid; }
        public void setHolid(){ this.holdid=holdid; }

        public int getAntalkørtekilometer(){ return antalkørtekilometer; }
        public void setAntalkørtekilometer(int antalkørtekilometer) { this.antalkørtekilometer=antalkørtekilometer; }

        public int getAntalkørtedage() { return antalkørtedage; }
        public void setAntalkørtedage(int antalkørtedage) { this.antalkørtedage=antalkørtedage; }
    }