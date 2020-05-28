package classmatedemo;


public class User {
    private String name, email, hometown,registration,bloodGroup,cgpa,semester,username,password;
    
    private boolean cricket,football,basketball,handball,volleyball,dance,music,debate,photography,acting,availableForBlood,isStudent;
    // users other than students wouldn be assigned "-1" as reg
    // queries would be executed only for students
    
    public static void main(String[] args) {
        User myUser;
        myUser=User.getBuilder().withBloodgroup("o+").withCGPA("4.00").withName("mahin").withHometown("SYL").build();
        System.out.println(myUser.name+"asdasd");
    }
    
    private User(Builder builder){
        this.name=builder.name;
        this.email=builder.email;
        this.registration=builder.registration;
        this.hometown=builder.hometown;
        this.cgpa=builder.cgpa;
        this.semester=builder.semester;
        this.username=builder.username;
        this.password=builder.password;
        this.bloodGroup=builder.bloodGroup;
    }
    
    public static Builder getBuilder(){
        return new User.Builder();
    }
    public static class Builder{
        
        private String name, email, hometown,registration,bloodGroup,cgpa,semester,username,password; 
        private boolean cricket,football,basketball,handball,volleyball,dance,music,debate,photography,acting,availableForBlood,isStudent; 
        
        Builder withName(String name){
            this.name=name;
            return this;
        }
        Builder withReg(String reg){
            this.registration=reg;
            return this;
        }
        Builder withEmail(String email){
            this.email=email;
            return this;
        }
        Builder withHometown(String hometown){
            this.hometown=hometown;
            return this;
        }
        Builder withBloodgroup(String bg){
            this.bloodGroup=bg;
            return this;
        }
        Builder withUsername(String username){
            this.username=username;
            return this;
        }
        Builder withCGPA(String cgpa){
            this.cgpa=cgpa;
            return this;
        }
        Builder withSemester(String semester){
            this.semester=semester;
            return this;
        }
        Builder withPassword(String pass){
            this.password=pass;
            return this;
        }
        User build(){
            return new User(this);
        } 
        
    }
    
}


