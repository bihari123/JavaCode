import java.util.ArrayList;
import java.util.Collections;

class Lege implements Comparable<Lege> {
    private String name;
    private Lenkeliste<Resepter> printedPrescription=new Lenkeliste<Resepter>();


  public Lege(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void addPrescription(Resepter r) {
    printedPrescription.leggTil(r);
  }

  public Lenkeliste<Resepter> getPresciprion() {
    return this.printedPrescription;
  }


 /* public void sortedDoctors(SortertLenkeliste<Lege> doctors){
    Collections.sort(doctors);
}
*/
  @Override
  public int compareTo(Lege anotherDoctor){
    return  this.name.compareTo(anotherDoctor.name);
    }

    public HviteResepter writeWhitePrescription(Legemiddel medicine,Pasient pasient , int reit) throws illegalPrinting{
       if (this instanceof Spesialist){
        HviteResepter whitePrescription =new HviteResepter(medicine, this, pasient, reit);
        this.addPrescription(whitePrescription);
        pasient.addNewPrescription(whitePrescription);
        return whitePrescription;
       }
        else if( medicine instanceof Narkotisk){
            throw new illegalPrinting(this , medicine);
        }
        else{
          HviteResepter whitePrescription =new HviteResepter(medicine, this, pasient, reit);
          this.addPrescription(whitePrescription);
          pasient.addNewPrescription(whitePrescription);
          return whitePrescription;
        }
        

    }

    public P_resepter writeP_Prescription(Legemiddel medicine,Pasient pasient) throws illegalPrinting{
      if( this instanceof Spesialist){
        P_resepter p_prescription =new P_resepter(medicine, this, pasient);
        this.addPrescription(p_prescription);
        pasient.addNewPrescription(p_prescription);
        return p_prescription;
      } 

      else if( medicine instanceof Narkotisk){
          throw new illegalPrinting(this , medicine);
      }


      else{
        P_resepter p_prescription =new P_resepter(medicine, this, pasient);
        this.addPrescription(p_prescription);
        pasient.addNewPrescription(p_prescription);
        return p_prescription;
      }
  }

  public Militærresepter writeMilitaryPrescription(Legemiddel medicine,Pasient pasient , int reit) throws illegalPrinting{
    if (this instanceof Spesialist){
      Militærresepter MilitaryPrescription =new Militærresepter(medicine, this, pasient, reit);
      this.addPrescription(MilitaryPrescription);
      pasient.addNewPrescription(MilitaryPrescription);
      return MilitaryPrescription;
    } 
    
    
    else if( medicine instanceof Narkotisk){
        throw new illegalPrinting(this , medicine);
    }


    else{
      Militærresepter MilitaryPrescription =new Militærresepter(medicine, this, pasient, reit);
      this.addPrescription(MilitaryPrescription);
      pasient.addNewPrescription(MilitaryPrescription);
      return MilitaryPrescription;
    }
  }

    public BlåResepter writeBluePrescription(Legemiddel medicine,Pasient pasient , int reit) throws illegalPrinting{
      if (this instanceof Spesialist){
        BlåResepter BluePrescription =new BlåResepter(medicine, this, pasient, reit);
        this.addPrescription(BluePrescription);
        pasient.addNewPrescription(BluePrescription);
        return BluePrescription;
      }
      
      
      else if( medicine instanceof Narkotisk){
          throw new illegalPrinting(this , medicine);
      }


      else{
        BlåResepter BluePrescription =new BlåResepter(medicine, this, pasient, reit);
        this.addPrescription(BluePrescription);
        pasient.addNewPrescription(BluePrescription);
        return BluePrescription;
      }

}


  @Override
  public String toString() {
    return ("Type: Doctor" + "\n" +
    "Name: " + getName() + "\n");
  }

}