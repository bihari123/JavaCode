import java.io.File;
import java.util.Scanner;

import java.io.IOException; 
import java.io.FileWriter; 

public class LegeSystem{

    private static SortertLenkeliste < Lege > doctors = new SortertLenkeliste < Lege > ();
    private static Lenkeliste < Legemiddel > medicine = new Lenkeliste < Legemiddel > ();
    private static Lenkeliste < Resepter > resepter = new Lenkeliste < Resepter > ();
    private static Lenkeliste < Pasient > pasients = new Lenkeliste < Pasient > ();


    public static void main(String[] args) {

        Scanner kommando = new Scanner(System.in);
        System.out.println("****************");
        System.out.println("\nLegeSystem V1.0s");
        menu();

        boolean kjoerer = true;

        while (kjoerer) {

            switch (kommando.nextLine()) {

                case "0":
                    Scanner d=new Scanner(System.in);
                    System.out.println("Enter the name of the file ( Avoid feeding the same file as it will create duplicate objects)");
                    readFromFile(d.nextLine());
                    break;
                case "1":
                    printOverview();
                    break;

                case "2":
                    add();
                    break;

                case "3":
                    usePrescription();
                    break;

                case "4":
                    viewStats();
                    break;
                
                case "5":
                    writeToFile();
                    break;    

                case "stopp":
                    System.out.println("Program terminating....");
                    kjoerer = false;
                    break;

                default:
                    System.out.println("Please enter a valid command");
                    break;
            }
        }
        kommando.close();
    }



    public static void readFromFile(String filename) {
        try {

            Scanner input = new Scanner(new File(filename));

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.contains("# Patients (name, dob)")) {
                    
                    System.out.println("reading started");
                    continue;
                } else if (!line.contains("# Medicine (name, type, price, active substance, [strength])")) {
                    System.out.println("p1");
                    String[] splitted = line.split(",");
                    Pasient p = new Pasient(splitted[0], splitted[1].trim());
                    pasients.leggTil(p);
                }
                if (line.contains("# Medicine (name, type, price, active substance, [strength])")) {
                    System.out.println("reading ended");
                    break;
                }

            }

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains("# Medicine (name, type, price, active substance, [strength])")) {
                    System.out.println("p2");
                    continue;
                } else if (!line.contains("# Doctors (name, control ID / 0 if regular doctor)")) {
                    String[] splitted = line.split(",");
                    
                    if (splitted[1].trim().equals("narcotic")){
                        System.out.println("here");
                        try{
                            if(splitted.length<5){
                                Narkotisk p = new Narkotisk(splitted[0], Double.parseDouble(splitted[2].trim()),  Double.parseDouble(splitted[3].trim()),0);
                                medicine.leggTil(p);
                            }else{
                                Narkotisk p = new Narkotisk(splitted[0], Double.parseDouble(splitted[2].trim()),  Double.parseDouble(splitted[3].trim()), Integer.parseInt(splitted[4].trim()));
                                medicine.leggTil(p);
                                } 
                            System.out.println("narcotic end");
                            
                            
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        

                    }

                    else if (splitted[1].trim().equals("addictive") ){
                        if(splitted.length<5){
                            Vanedannende p = new Vanedannende(splitted[0], Double.parseDouble(splitted[2].trim()),  Double.parseDouble(splitted[3]), 0);
                            medicine.leggTil(p);    
                        }else{
                            Vanedannende p = new Vanedannende(splitted[0], Double.parseDouble(splitted[2].trim()),  Double.parseDouble(splitted[3].trim()), Integer.parseInt(splitted[4].trim()));
                            medicine.leggTil(p);
                        }
                    }

                    else if (splitted[1].trim().equals("common") ){
                        if(splitted.length<4){
                            Vanlig p = new Vanlig(splitted[0], Double.parseDouble(splitted[2].trim()),  0.0);
                            medicine.leggTil(p);    
                        }else{
                            Vanlig p = new Vanlig(splitted[0], Double.parseDouble(splitted[2].trim()),  Double.parseDouble(splitted[3].trim()));
                            medicine.leggTil(p);
                        }
                        
                    }
                }
                else if (line.contains("# Doctors (name, control ID / 0 if regular doctor)")) {
                    System.out.println("p3");
                    break;
                }
                

            }


            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.contains("# Doctors (name, control ID / 0 if regular doctor)")) {
                    System.out.println("p4");
                    continue;
                } else if (!line.contains("# Prescriptions (medicineNumber, doctorName, patientID, type, [reit])")) {
                    String[] splitted = line.split(",");
                    if(Integer.parseInt(splitted[1].trim())!=0){
                        Spesialist p =new Spesialist(splitted[0],Integer.parseInt(splitted[1].trim()));
                        doctors.leggTil(p);
                    }
                    else{
                        Lege p=new Lege(splitted[0]);
                        doctors.leggTil(p);
                        
                    }
                }
                if (line.contains("# Prescriptions (medicineNumber, doctorName, patientID, type, [reit])")) {
                    System.out.println("p5");
                    break;
                }

            }



            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.contains("# Prescriptions (medicineNumber, doctorName, patientID, type, [reit])")) {
                    System.out.println("p6");
                    continue;
                } else  {
                    try{
                        String[] splitted = line.split(",");
                        int medicine_no=Integer.parseInt(splitted[0]);
                        String doctor_name=splitted[1].trim();
                        int patient_id=Integer.parseInt(splitted[2].trim());
                        String type=splitted[3].trim();

                        int reit;
                        if(splitted.length<5){
                            reit=0;
                        }else{
                            reit=Integer.parseInt(splitted[4].trim());
                        }
                    
                        for (Lege doc : doctors) {

                           if (doctor_name.equals(doc.getName())){
                            System.out.println(doctor_name);
                            for(Pasient p: pasients){

                                if(patient_id==p.getPatientId()){
                                    System.out.println(Integer.toString(patient_id));
                                    for(Legemiddel m: medicine){
                                   
                                        if(medicine_no==m.hentId()){
                                            System.out.println("p9");
                                            System.out.println(type);
                                            
                                            if(type.equals("white")){
                                                System.out.println("p10");
                                                try{
                                                  HviteResepter white= doc.writeWhitePrescription(m, p, reit);
                                                  
                                                  resepter.leggTil(white);
                                                  System.out.println("p10");
                                                }catch(Exception e){
                                                    System.out.println(e);
                                                }
                                          }
                                   
                                           else if(type.equals("blue")){
                                            System.out.println("p44");
                                            
                                            if(m instanceof Narkotisk){
                                   
                                                if(doc instanceof Spesialist){
                                                    BlåResepter blue= doc.writeBluePrescription(m, p, reit);
                                                    resepter.leggTil(blue);
                                                }
                                   
                                                else{
                                                    throw new illegalPrinting(doc, m);
                                                }
                                            }   
                                            BlåResepter blue= doc.writeBluePrescription(m, p, reit);
                                            resepter.leggTil(blue);
                                           }
                                   
                                           else if(type.equals("military")){
                                              System.out.println("p55");
                                            
                                               Militærresepter military= doc.writeMilitaryPrescription(m, p, reit);
                                               resepter.leggTil(military);
                                       }
                                   
                                           else if(type.equals("p")){
                                               P_resepter p_res= doc.writeP_Prescription(m, p);
                                               resepter.leggTil(p_res);
                                       }
                                   }
                                }
                            } 
                        }  
                   }
                }
            }catch(Exception e){
                System.out.println(e);
            }
                   

                   
                }
                

            }



            input.close();
            System.out.println("Operation complete");

        } catch (Exception unntak) {
            unntak.printStackTrace();
        }

        menu();
    }


    public static void printOverview() {
        int tellerLG = 0;

        System.out.println("**** PASIENTER ****\n");
        for (Pasient pa: pasients) {
            System.out.println("Navn: " + pa.getName());
            System.out.println("Foedselsnummer: " + pa.getDataOfBirth() + "\n");
        }

        System.out.println("**** LEGER ****\n");
        for (Lege lg: doctors) {
            System.out.println(lg + "ID: " + tellerLG + "\n");
            tellerLG++;
        }

        System.out.println("**** medicine ****\n");
        for (Legemiddel lm: medicine) {
            System.out.println(lm);
        }

        System.out.println("**** RESEPTER ****\n");
        for (Resepter re: resepter) {
            System.out.println(re.legemiddel.hentId()+", "+re.utskrivendeLege.getName()+", "+re.pasient.getPatientId());
        }
        menu();


    }

    public static void menu() {

        System.out.println("\n");
        System.out.println("****************");
        System.out.println("\nUse the following commands to proceed. Only enter the brackets content:\n");
        System.out.println("(0) - Read data from a file");
        System.out.println("(1) - Print a complete list of people, doctors, medicines and prescriptions");
        System.out.println("(2) - Create objects");
        System.out.println("(3) - Use specific prescriptions");
        System.out.println("(4) - view stats");
        System.out.println("(5) - write data to file");
        System.out.println("Type stop to exit");

    }


    public static void add() throws UgyldigListeIndeks {

        System.out.println("What do you want to create?");
        System.out.println("(1) - Patient");
        System.out.println("(2) - Doctor");
        System.out.println("(3) - Medicine");
        System.out.println("(4) - Resept");

        Scanner scan = new Scanner(System.in);
        String valg;

        valg = scan.nextLine();

        switch (valg) {
            case "1":
                System.out.println("Pasient");

                Scanner pasientScan = new Scanner(System.in);
                String pasientNy;

                System.out.println("Enter name and food number (Format: name, food number)");

                pasientNy = pasientScan.nextLine();

                String[] splitPasient = pasientNy.split(",");
                String nyNavnPasient = splitPasient[0];
                String dob=splitPasient[1];
                Pasient nyPasient = new Pasient(nyNavnPasient, dob);

                pasients.leggTil(nyPasient);

                System.out.println("\ncreated patient\n");
                System.out.println(nyPasient);

                break;

            case "2":
                System.out.println("Doctor");

                Scanner legeScan = new Scanner(System.in);
                String legeNy;

                System.out.println("Enter name and any agreement number (Format: name, agreement number)");
                System.out.println("Use 0 as the contract number if it does not exist");

                legeNy = legeScan.nextLine();

                String[] splitted = legeNy.split(",");
                String nyNavn = splitted[0];


                try {

                    if (Integer.parseInt(splitted[1]) != 0) {
                        Spesialist nyFastlege = new Spesialist(nyNavn, Integer.parseInt(splitted[1]));

                        doctors.leggTil(nyFastlege);

                        System.out.println("\nAvtalenummer oppgitt. Oppretter fastlege.\n");
                        System.out.println(nyFastlege);

                    } else {
                        Lege nyLege = new Lege(nyNavn);

                        doctors.leggTil(nyLege);

                        System.out.println("\nAvtalenummer er ikke oppgitt. Oppretter lege.\n");
                        System.out.println(nyLege);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("\nERROR: Agreement number is too long, or not valid\n");
                }
                
                break;

            case "3":
                System.out.println("Medicine");

                Scanner legemiddelScan = new Scanner(System.in);
                String select;

                System.out.println("What kind of drug do you want to create?");
                System.out.println("(1) - Narkotisk");
                System.out.println("(2) - Addictive");
                System.out.println("(3) - Common");

                select = legemiddelScan.nextLine();

                switch (select) {
                    case "1":
                        System.out.println("Enter information about the drug: (format: name, price, active substance, narcotic strength)");

                        select = legemiddelScan.nextLine();

                        String[] splitLMA = select.split(",");
                        String nyttLegemiddelA = splitLMA[0];

                        Narkotisk nyttA = new Narkotisk(splitLMA[0], Double.parseDouble(splitLMA[1]), Double.parseDouble(splitLMA[2]), Integer.parseInt(splitLMA[3]));
                        medicine.leggTil(nyttA);
                        System.out.println(nyttA);

                        break;

                    case "2":
                        System.out.println("Tast inn informasjon om legemiddelet: (format: navn, pris, virkestoff, vannedannende styrke)");

                        select = legemiddelScan.nextLine();

                        String[] splitLMB = select.split(",");
                        String nyttLegemiddelB = splitLMB[0];

                        Vanedannende nyttB = new Vanedannende(splitLMB[0], Double.parseDouble(splitLMB[1]), Double.parseDouble(splitLMB[2]), Integer.parseInt(splitLMB[3]));
                        medicine.leggTil(nyttB);
                        System.out.println(nyttB);
                        break;

                    case "3":
                        System.out.println("Tast inn informasjon om legemiddelet: (format: navn, pris, virkestoff)");

                        select = legemiddelScan.nextLine();

                        String[] splitLMC = select.split(",");
                        String nyttLegemiddelC = splitLMC[0];

                        Vanlig nyttC = new Vanlig(splitLMC[0], Double.parseDouble(splitLMC[1]), Double.parseDouble(splitLMC[2]));
                        medicine.leggTil(nyttC);
                        System.out.println(nyttC);
                        break;

                    case "stopp":
                        break;
                }
                break;


            case "4":
                System.out.println("Resept");

                Scanner reseptScan = new Scanner(System.in);
                String reseptNy;

                System.out.println("What kind of recipe do you want to create?");
                System.out.println("(1) -Blue resept");
                System.out.println("(2) - White resept");
                System.out.println("(3) - P prescription");
                System.out.println("(4) - Millitary prescription");


                reseptNy = reseptScan.nextLine();

                System.out.println("** List of possible patients **");
                int tellerPA = 0;

                for (Pasient pa: pasients) {
                    System.out.println(tellerPA + " : " + pa.getName());
                    tellerPA++;
                }

                System.out.println("** List of possible doctors **");
                int tellerLG = 0;

                for (Lege lg: doctors) {
                    System.out.println(tellerLG + " : " + lg.getName());
                    tellerLG++;
                }

                System.out.println("** List of possible medicines **");
                int tellerLM = 0;

                for (Legemiddel lm: medicine) {
                    System.out.println(tellerLM + " : " + lm.hentNavn());
                    tellerLM++;
                }
                Lege lege;
                Pasient pasient;
                switch (reseptNy) {
                    case "1":

                        System.out.println(" Enter information about the prescription: (format: ID on patient, ID on physician, ID on drug, number of boxes)");
                        String nyBlaa;

                        nyBlaa = reseptScan.nextLine();
                        try{
                            String[] splitRB = nyBlaa.split(",");
                            try{
                            lege = doctors.hent(Integer.parseInt(splitRB[1]));
                        
                            pasient = pasients.hent(Integer.parseInt(splitRB[0]));
                            
                                try{ 
                                    BlåResepter nyB  = lege.writeBluePrescription(medicine.hent(Integer.parseInt(splitRB[2])),  pasient, Integer.parseInt(splitRB[3]));
                                    resepter.leggTil(nyB);
                                 //   lege.addPrescription(nyB);;
                                    pasient. addNewPrescription(nyB);
                                    System.out.println(nyB);
                                }catch(illegalPrinting e){
                                    System.out.println(e);
                            }
                            }catch(UgyldigListeIndeks e){
                                   System.out.print("Please enter a valid value");
                                }
                        }catch(NumberFormatException e){
                            System.out.println("please enter a valid input");
                        }
                        break;

                    case "2":

                        System.out.println("Enter information about the prescription: (format: ID on patient, ID on physician, ID on drug, number of boxes)");
                        String nyHvit;

                        nyHvit = reseptScan.nextLine();
                        try{
                             String[] splitRH = nyHvit.split(",");
                             try{
                            lege = doctors.hent(Integer.parseInt(splitRH[1]));
                            pasient = pasients.hent(Integer.parseInt(splitRH[0]));
                            
                                try{
                                HviteResepter nyH = lege.writeWhitePrescription(medicine.hent(Integer.parseInt(splitRH[2])),  pasient, Integer.parseInt(splitRH[3]));
                                resepter.leggTil(nyH);
                               // lege.addPrescription(nyH);
                                pasient. addNewPrescription(nyH);
                                System.out.println(nyH);
                            }catch(illegalPrinting e){
                                System.out.println(e);
                            }
                        }catch(UgyldigListeIndeks e){
                              System.out.print("Please enter a valid value");
                            }
                        }catch(NumberFormatException e){
                             System.out.println("please enter a valid input");
                        }
             
                        break;

                    case "3":
                        System.out.println("Enter information about the prescription: (format: ID on patient, ID on physician, ID on drug)");
                        String nyPrev;

                        nyPrev = reseptScan.nextLine();
                        try{
                            String[] splitRP = nyPrev.split(",");
                            try{ 
                            lege = doctors.hent(Integer.parseInt(splitRP[1]));
                            pasient = pasients.hent(Integer.parseInt(splitRP[0]));
                           
                                try{
                                    P_resepter nyP = lege.writeP_Prescription(medicine.hent(Integer.parseInt(splitRP[2])),  pasient);
                                    resepter.leggTil(nyP);
                                    //lege.addPrescription(nyP);
                                    pasient. addNewPrescription(nyP);
                                    System.out.println(nyP);
                                 }catch(illegalPrinting e){
                                     System.out.println(e);
                                }
                            }catch(UgyldigListeIndeks e){
                                System.out.print("Please enter a valid value");
                             }
                        }catch(NumberFormatException e){
                             System.out.println("please enter a valid input");
                        }
                       break;

                    case "4":
                        System.out.println("Enter information about the prescription: (format: ID on patient, ID on physician, ID on drug, number of boxes)");
                        String nyMill;

                        nyMill = reseptScan.nextLine();
                        try{ 
                           String[] splitRM = nyMill.split(",");
                           try{
                            lege = doctors.hent(Integer.parseInt(splitRM[1]));
                            pasient = pasients.hent(Integer.parseInt(splitRM[0]));
                            
                                try{
                                    Militærresepter nyM = lege.writeMilitaryPrescription(medicine.hent(Integer.parseInt(splitRM[2])),  pasient, Integer.parseInt(splitRM[3]));
                                    resepter.leggTil(nyM);
                               //     lege.addPrescription(nyM);
                                    pasient. addNewPrescription(nyM);

                                    System.out.println(nyM);
                                }catch(illegalPrinting e){
                                    System.out.println(e);
                             }
                            }catch(UgyldigListeIndeks e){
                                  System.out.print("Please enter a valid value");
                               }
                         }catch(NumberFormatException e){
                             System.out.println("please enter a valid input");
                     }
                    break;

                    case "stopp":
                        break;
                }
                break;

        }

       menu();

    }

    public static void viewStats() {

        System.out.println("What statistics would you like to print?");
        System.out.println("(1) - Number of prescriptions for Addictive Drugs");
        System.out.println("(2) - Number of addictive prescriptions for military");
        System.out.println("(3) - Statistics on possible drug abuse");

        Scanner scan = new Scanner(System.in);
        String valg;

        valg = scan.nextLine();

        switch (valg) {

            case "1":
                int antVanedannende = 0;

                for (Resepter r: resepter) {
                    if (r.hentLegemiddel() instanceof Vanedannende) {
                        antVanedannende++;
                    }
                }

                System.out.println("Number of addictive recipes: " + antVanedannende);
                break;

            case "2":
                int antVaneMilitaer = 0;

                for (Resepter r: resepter) {
                    if (r instanceof Militærresepter) {
                        if (r.hentLegemiddel() instanceof Vanedannende) {
                            antVaneMilitaer++;
                        }
                    }
                }

                System.out.println("Number of addictive recipes for military:" + antVaneMilitaer);
                break;

            case "3":
                for (Lege l: doctors) {
                    int narkotiskLege = 0;

                    for (Resepter r: l.getPresciprion()) {
                        if (r.hentLegemiddel() instanceof Narkotisk) {
                            narkotiskLege++;
                        }
                    }
                    if (narkotiskLege > 0) {
                        System.out.println(l.getName() + " printing complete" + narkotiskLege + " narkotiske resepter.");
                    }
                }


                for (Pasient p: pasients) {
                    int narkotiskPasient = 0;

                    for (Resepter r: p.getPrescriptionList()) {
                        if (r.hentLegemiddel() instanceof Narkotisk) {
                            if (r.hentReit() > 0) narkotiskPasient++;
                        }
                    }
                    if (narkotiskPasient > 0) {
                        System.out.println(p.getName() + " har " + narkotiskPasient + " narkotiske resepter.");
                    }
                }

                break;

            case "stopp":
                break;

        }

        menu();

    }

public static void usePrescription(){
    int selected_id; 
    System.out.println("Which patient would you like to see a prescription for?");
  
    for (Pasient pa: pasients) {
        System.out.println(pa.getPatientId() + " : " + pa.getName());
        
    }

    Scanner scan = new Scanner(System.in);
    try{
    selected_id = Integer.parseInt(scan.nextLine());
    Pasient pasient = pasients.hent(selected_id);
    System.out.println("** Selected patient:" + pasient.getName() + " (Fnr: " + pasient.getDataOfBirth() + ") **");
    System.out.println("Id : resept");
    
   
    for(Resepter r: resepter){
        if(r.hentPasientId()==selected_id){
            System.out.println(r.hentId()+" : " + r.hentLegemiddel().hentNavn() + " (Antall reit: " + r.hentReit() + ")");
           
        }
    }

    System.out.println("Enter the id of the prescription that you want to use");
    int valg = Integer.parseInt(scan.nextLine());
    if(resepter.hent(valg).pasient.getPatientId()==selected_id){
        
    Resepter resept = resepter.hent(valg);

    if (resept.bruk()) {
        System.out.println("Prescription used. Remaining field: " + resept.hentReit());
    } else {
        System.out.println(" No remaining field. Prescription is not used.");
    }
    }
    else{
        System.out.println("Please enter a valid id");
    }     
}catch(NumberFormatException e){
    System.out.print("please enter a valid input");
}

    menu();


}
    public static void writeToFile(){
        String fileName= "Medical.txt";
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
         } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
         
          try {
            FileWriter myWriter = new FileWriter(fileName,true);   
            myWriter.write("#Patient(name,dob) \n");
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          for(Pasient p:pasients){
              
                String text= p.getName()+","+p.getDataOfBirth()+"\n";
                try {
                    FileWriter myWriter = new FileWriter(fileName,true);   
                    myWriter.write(text);
                    myWriter.close();
                    
                  } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                    }      
              
          }
       /*   Scanner scan = new Scanner(System.in);
          System.out.println("Write the name and dob of the patients (Press q in the third line to finish) \n");
          
          String s=new String();
          Boolean t=true;
          while(t){
            String name = scan.nextLine();
            String dob=scan.nextLine();
            String text=name+","+dob+"\n";
            
            try {
                FileWriter myWriter = new FileWriter(fileName,true);   
                myWriter.write(text);
                myWriter.close();
                
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                }
                
                s=scan.nextLine();
               if(s.equals("q")){
                   t=false;
               }
               System.out.println("Feed the next entry");
          }
         
         */
         try {
            FileWriter myWriter = new FileWriter(fileName,true);   
            myWriter.write("# Medicine (name, type, price, active substance, [strength]) \n");
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          for(Legemiddel m:medicine){
            String type=new String();
            String strength=new String();  
            if(m instanceof Narkotisk){
                  type="narcotic";
                  strength=Integer.toString(((Narkotisk) m).hentNarkotiskStyrke());
              }
              else if(m instanceof Vanedannende){
                  type="addictive";
                  strength=Integer.toString(((Vanedannende) m).hentVanedannendeStyrke());
              }else{
                  type="common";
                  strength="";
              }
            String text= m.hentNavn()+","+type+","+m.hentPris()+","+m.hentVirkestoff()+","+strength+"\n";
            try {
                FileWriter myWriter = new FileWriter(fileName,true);   
                myWriter.write(text);
                myWriter.close();
                
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                }      
          
      }
        /*  System.out.println("Write the name of the Medicines (format: name, type, price, active substance, [strength (optional)]) (Press q to finish) \n");
          t=true;
          s=" ";
          while(t){
            String name = scan.nextLine();
            String type=scan.nextLine();
            String price=scan.nextLine();
            String activeSubstance=scan.nextLine();
            String strength=scan.nextLine();

            String text=name+","+type+","+price+","+activeSubstance+","+strength+"\n";
            
            try {
                FileWriter myWriter = new FileWriter(fileName,true);   
                myWriter.write(text);
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }

              s=scan.nextLine();
              if(s.equals("q")){
                  t=false;
              }
              if(t){
                  System.out.println("Feed the next entry");
              }
          }

*/
          try {
            FileWriter myWriter = new FileWriter(fileName,true);   
            myWriter.write("# Doctors (name, control ID / 0 if regular doctor) \n");
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          for(Lege p:doctors){
            String id="0";  
            if(p instanceof Spesialist){
                  id="123";
              }

            String text= p.getName()+","+id+"\n";
            try {
                FileWriter myWriter = new FileWriter(fileName,true);   
                myWriter.write(text);
                myWriter.close();
                
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                }      
          
      }
          
  /*        System.out.println("Write the name of the# Doctors (name, control ID / 0 if regular doctor) (Press q to finish) \n");

          t=true;
          s=" ";
          while(t){
            String name = scan.nextLine();
            String id=scan.nextLine();
            String text=name+","+id+"\n";
            
            try {
                FileWriter myWriter = new FileWriter(fileName,true);   
                myWriter.write(text);
                myWriter.close();
               } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }

              s=scan.nextLine();
              if(s.equals("q")){
                  t=false;
              }
              if(t){
                System.out.println("Feed the next entry");
              
              }

          }

*/
          try {
            FileWriter myWriter = new FileWriter(fileName,true);   
            myWriter.write("# Prescriptions (medicineNumber, doctorName, patientID, type, [reit]) \n");
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          for(Resepter p:resepter){
            String type="";
            if(p instanceof P_resepter){
                type="p";
            }     
            else if(p instanceof Militærresepter){
                type="military";
            }
            else if(p instanceof HviteResepter){
                type="white";
            }
            else if(p instanceof BlåResepter){
                type="blue";
            }
            String text= p.legemiddel.hentId()+","+p.utskrivendeLege.getName()+","+p.pasient.getPatientId()+","+type+","+p.hentReit()+"\n";
            try {
                FileWriter myWriter = new FileWriter(fileName,true);   
                myWriter.write(text);
                myWriter.close();
                
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                }      
          
      }
  /*        t=true;
          s=" ";
          System.out.println("Enter Prescriptions (medicineNumber, doctorName, patientID, type, [reit])");
          while(t){
            String medicineNumber = scan.nextLine();
            String doctorName=scan.nextLine();
            String patientId=scan.nextLine();
            String type=scan.nextLine();
            String reit=scan.nextLine();

            String text=medicineNumber+","+doctorName+","+patientId+","+type+","+reit+"\n";
            
            try {
                FileWriter myWriter = new FileWriter(fileName,true);   
                myWriter.write(text);
                myWriter.close();
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }

              s=scan.nextLine();
              if(s.equals("q")){
                  t=false;
              }
              if(t){
                System.out.println("Feed the next entry");
              
              }

          }
          
          */System.out.println("thank you, have a nice day");

          // scan.close();
          menu();



     }
    
    
}