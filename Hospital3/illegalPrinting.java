public class illegalPrinting extends Exception{
    illegalPrinting (Lege l,Legemiddel lm){
        super("Doctor "+l.getName()+" is not allowed to pring "+lm.hentNavn());
    }
} 