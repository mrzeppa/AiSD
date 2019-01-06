import java.util.ArrayList;

public class Hash {
    public int hashing(String surname){
        int hash = 0;
        int surnameLength = surname.length();
        int letter;
        int code;
        int c1 = 967, c2 = 1001;
        for (int i = 0; i < surnameLength; i++){
            letter = surname.charAt(i);
            code = letter + (c1 * i) + (c2 * i * i);
            hash = (hash + code);
        }
        return hash%11754;
    }

    public int controlHashing(String surname){
        int hash = 0;
        int surnameLength = surname.length();
        int letter;
        int code;
        int c1 = 967, c2 = 1001;
        for (int i = 0; i < surnameLength; i++){
            letter = surname.charAt(i);
            code = letter + (c1 * i) + (c2 * i * i);
            hash = (hash + code);
        }
        return hash%14;
    }

    public void codeElement(ArrayList<Record> a, ArrayList<EmptyRecord> b){
        int index;
        int beginning;
        int c = a.size();
        for(int i = 0; i < a.size(); i++){
            index = hashing(a.get(i).getSurname());
            beginning = index;
//            System.out.println(index);
            while(index < a.size() && !b.get(index).getNumber().equals("0")){
                index++;
            }

            if(index < a.size() && b.get(index).getNumber().equals("0")){
                b.get(index).setSurname(a.get(i).getSurname());
                b.get(index).setNumber(a.get(i).getNumber());
            }
            if(index == a.size()){
                index = 0;
                while(index < beginning && !b.get(index).getNumber().equals("0")){
                    index++;
                }
                if(index < beginning && b.get(index).getNumber().equals("0")){
                    b.get(index).setSurname(a.get(i).getSurname());
                    b.get(index).setNumber(a.get(i).getNumber());
                }
                if (index == beginning){
                    System.out.println("KONIEC TABLICY");
                }
            }
        }
    }

    public void codeControlElements(ArrayList<ControlRecords> a, ArrayList<EmptyControlRecords> b){
        int index;
        int beginning;
        int c = a.size();
        for(int i = 0; i < a.size(); i++){
            index = controlHashing(a.get(i).getSurname());
            beginning = index;
//            System.out.println(index);
            while(index < a.size() && !b.get(index).getNumber().equals("0")){
                index++;
            }

            if(index < a.size() && b.get(index).getNumber().equals("0")){
                b.get(index).setSurname(a.get(i).getSurname());
                b.get(index).setNumber(a.get(i).getNumber());
            }
            if(index == a.size()){
                index = 0;
                while(index < beginning && !b.get(index).getNumber().equals("0")){
                    index++;
                }
                if(index < beginning && b.get(index).getNumber().equals("0")){
                    b.get(index).setSurname(a.get(i).getSurname());
                    b.get(index).setNumber(a.get(i).getNumber());
                }
                if (index == beginning){
                    System.out.println("KONIEC TABLICY");
                }
            }
        }
    }

    public void hashSearch( ArrayList<LastFewRecords> c, ArrayList<EmptyRecord> b){
        int tries = 0;
        String surname;
        for(LastFewRecords x: c) {
            tries = 0;
            surname = x.getSurname();
            for (EmptyRecord y: b) {
                tries++;
                if (y.getSurname().equals(surname)) {
                    System.out.println("Nazwisko " + surname + " znaleziono. Ilosc prób: " + tries);
                    break;
                }
            }
        }
    }

}
