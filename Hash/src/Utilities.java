import sun.invoke.empty.Empty;

import java.io.*;
import java.util.ArrayList;


class Record
{
    private String number;
    private String surname;
    private int hashCode;


    public Record(String number, String surname, int hashCode)
    {
        this.number = number;
        this.surname = surname;
        this.hashCode = hashCode;
    }

    public String toString() {
        return number + " " + surname + " " + hashCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

}

class EmptyRecord{
    private String number;
    private String surname;

    public EmptyRecord(String number, String surname) {
        this.number = number;
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return number + " " + surname;
    }
}

class LastFewRecords{
    private String number;
    private String surname;

    public LastFewRecords(String number, String surname) {
        this.number = number;
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

class ControlRecords{
    private String number;
    private String surname;

    public ControlRecords(String number, String surname) {
        this.number = number;
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return number +  " " + surname;
    }
}

class EmptyControlRecords{
    private String number;
    private String surname;

    public EmptyControlRecords(String number, String surname) {
        this.number = number;
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return number +  " " + surname;
    }
}


class FileSupport
{
    public void getRecordsFromFile(ArrayList<Record> a, ArrayList<EmptyRecord> b, ArrayList<LastFewRecords> c, ArrayList<ControlRecords> d, ArrayList<EmptyControlRecords> f) {
        try (BufferedReader br = new BufferedReader(new FileReader("nazwiska.txt"))) {
            int lineCounter = 0;
            a.clear();

            String line;

            while ((line = br.readLine()) != null) {
                String[] temp = line.split("\\s+");

                if(lineCounter < 20 && lineCounter >= 0){
                    d.add(new ControlRecords(temp[0], temp[1]));
                    f.add(new EmptyControlRecords("0", "brak"));
                }

                if(lineCounter <= 16000) {
                    b.add(new EmptyRecord(temp[0], temp[1]));
                    a.add(new Record(temp[0], temp[1], 0));
                }
                if(lineCounter > 16000){
                    b.add(new EmptyRecord(temp[0], temp[1]));
                    a.add(new Record("0", "brak", 0));
                }

                if(lineCounter > 15980 && lineCounter <= 16000){
                    c.add(new LastFewRecords(temp[0], temp[1]));
                }
                lineCounter++;

            }
            for(EmptyRecord x: b){
                x.setNumber("0");
                x.setSurname("brak");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveRecordsToFile(ArrayList<EmptyRecord> a, String fileName)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            for (EmptyRecord x: a)
            {
                writer.write(x.getNumber() + " " + x.getSurname());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
