import java.io.*;
import java.util.*;  

public class NameSorting {

public static void main(String arg[])
{

System.out.println (" Hi iiiiiiiiiiiiiiii");
try {
File inputFile = new File("input.txt");

BufferedReader br = new BufferedReader(new FileReader(inputFile ));

String line;
HashMap<String, String> hmap = new HashMap<String, String>();


List<Person> personList = new ArrayList<Person>();
while ( (line = br.readLine()) != null )
{

String nameArr[]=line.split(",");
Person per = new Person();
//System.out.println(nameArr[0]+ "" +nameArr[1]);
per.setLastName(nameArr[0]);
per.setFirstName(nameArr[1]);
personList.add(per);
}


System.out.println("=============Before Sorting ==================");
ListIterator<Person> litr = personList.listIterator();

while(litr.hasNext()){
       Person p =litr.next();
       System.out.println(p.getLastName()+" "+ p.getFirstName());
 
    }
 
sortPersons(personList);


System.out.println("=============After Sorting ==================");
ListIterator<Person> litr1 = personList.listIterator();
FileWriter filewrite = new FileWriter("input_sorted.txt");
BufferedWriter bufferwrite = new BufferedWriter(filewrite);

while(litr1.hasNext()){
       Person p =litr1.next();
       System.out.println(p.getLastName()+" "+ p.getFirstName());
       bufferwrite.write(p.getLastName()+" , "+ p.getFirstName()+"\n");
    }

bufferwrite.close();

}
catch(Exception e)
{
System.out.println("Error :"+e);
}

}

public static void sortPersons(List personList) {
    for (int i = 0; i < personList.size(); i++) {
        for (int j = 0; j < personList.size(); j++) {
            Collections.sort(personList, new Comparator() {

                public int compare(Object o1, Object o2) {
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
                int res =  p1.getLastName().compareToIgnoreCase(p2.getLastName());
                if (res != 0)
                    return res;
                return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
            }
            });
        }

    }
}

}
