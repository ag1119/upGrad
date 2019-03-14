import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int events = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Student> queue = new PriorityQueue<>();
        for(int e = 0; e < events; e++){
            String[] inp = br.readLine().trim().split(" ");
            if(inp.length > 1 && inp[0].equals("ENTER"))
            {
                Student s = new Student(Double.parseDouble(inp[2]) , inp[1] , Integer.parseInt(inp[3]));
                queue.add(s);
            }
            else if(inp.length == 1 && inp[0].equals("SERVED")){
                Student s = queue.poll();
                //System.out.println("removed----->  " + "CGPA--> " + s.CGPA + " name--> " + s.name + " token no--> " + s.token);
            }

        }

        if(queue.isEmpty())
            System.out.println("EMPTY");

        while (!queue.isEmpty()){
            System.out.println(queue.poll().name);
        }

    }
}



class Student implements Comparable<Student>{
    Double CGPA;
    String name;
    Integer token;
    public Student(Double CGPA , String name, Integer token){
        this.CGPA = CGPA;
        this.name = name;
        this.token = token;
    }

    @Override
    public int compareTo(Student o) {
      if(Double.compare(o.CGPA,this.CGPA)==0)// if CGPA is equal then we will check name
      {
          if(name.equals(o.name)) // If names are also equal then we will give priority to the token in ascending order
          {
              return Integer.compare(this.token,o.token);
          }
          else{ // if names are not equal
             return this.name.compareTo(o.name);

          }
      }
      else // if CGPA is not equal
          return Double.compare(o.CGPA,this.CGPA);
    }
}

//Sir please let me know if you want me to implement the priority queue from scratch then i can implement that also.