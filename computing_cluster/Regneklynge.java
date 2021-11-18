import java.io.*;
import java.util.ArrayList;
 
class Regneklynge {
	ArrayList<Rack> regneklynge ;
	public int noder_per_rack; 
	public int antall_rack  ;

	public Regneklynge( int noder_per_rack) {
		// TODO Auto-generated constructor stub
		this.regneklynge =  new ArrayList<>();
		this.noder_per_rack = noder_per_rack;
		this.antall_rack = 0 ; 
         
	}

	public Regneklynge( String file) {
		// TODO Auto-generated constructor stub
		this.regneklynge =  new ArrayList<>();
		int[] minne_storrelse = new int[3];
		int[] prosessor_antall = new int[3];
		int[] num_of_nodes=new int[3];
		int i=0;
		try{
			FileInputStream input_file=new FileInputStream(file);
			DataInputStream input_data= new DataInputStream(input_file);
			BufferedReader reader=new BufferedReader(new InputStreamReader(input_data));
			String line;
			while((line= reader.readLine())!= null){
				String[] data =line.split(" ");
				if (data.length  == 1){
					this.noder_per_rack = Integer.parseInt(data[0]);
					print(" nodes per rack is "+ Integer.toString(this.noder_per_rack));
				}
				else{
					minne_storrelse[i] = Integer.parseInt(data[1]);
					prosessor_antall[i] = Integer.parseInt(data[2]);
					num_of_nodes[i]=Integer.parseInt(data[0]);
					Node new_node= new Node(minne_storrelse[i],prosessor_antall[i]);
					this.addNode( new_node);
					i++;
				
					
					
					
					 
				}
			}
			input_data.close();
		}catch(Exception ioException){
			print("printing error");
			System.err.println("Error: "+"e.getMessage() ");
		}
	}
	public void addNode(Node node) {
		
	
		if (this.num_antall_racks() == 0) {
			
			this.regneklynge.add(new Rack(this.noder_per_rack));

			this.regneklynge.get(antall_rack).add_node(node); 

		}
		else if (this.regneklynge.get(antall_rack).erFull() >= this.noder_per_rack) { 
			this.antall_rack += 1; 
			this.regneklynge.add(new Rack(this.noder_per_rack));  
			this.regneklynge.get(antall_rack).add_node(node); 
		}
		else {
			this.regneklynge.get(antall_rack).add_node(node);
		}
}
	public int antProsessorer() { 
		int total_antall_prosessorer = 0;
		for (int i=0; i<regneklynge.size(); i++) { 
			total_antall_prosessorer += regneklynge.get(i).antProsessorer() ;
		}
		return total_antall_prosessorer;
	}
	
	public int noderMedNokMinne(int paakrevdMinne) {  
		int total_antall = 0;
		for (int i=0; i<regneklynge.size(); i++) {
			total_antall += regneklynge.get(i).noderMedNokMinne(paakrevdMinne);//noderMedNokMinne=nodesWithEnoughMemory
		}
	
		return total_antall;
	}
	public int num_antall_racks() {
		return this.regneklynge.size();
	}


     public static void main(String[] args) {
		//Regneklynge abel =new Regneklynge(12);
		Regneklynge abel2 =new Regneklynge("regneklynge3.txt");
		/*
		for (int i=0; i<650; i++) {
			Node node =new Node (64,1);
			abel.addNode(node);
			abel2.addNode(node);
		}
		
		for (int i=0; i<16; i++) {
			Node node =new Node (1024,2);
			abel.addNode(node);
		}
		*/
		print("Noder med minst 32 GB:"+ Integer.toString(abel2.noderMedNokMinne(32)));
	    print("Noder med minst 64 GB:"+ Integer.toString(abel2.noderMedNokMinne(64)));
	    print("Noder med minst 128 GB:"+ Integer.toString(abel2.noderMedNokMinne(128)));
	    print("Antall prosessorer:"+ Integer.toString(abel2.antProsessorer()));
	    print("Antall rack:"+ Integer.toString(abel2.num_antall_racks()));

	}
		
	
	
	public static  void print(String s) {
		System.out.print(s + "\n");
	}
		
	}



class Rack extends Regneklynge {

    


    private  ArrayList<Node> liste_av_rack;
	
	public Rack(int noder_per_rack) {
		   super(noder_per_rack);
	       this.liste_av_rack =new  ArrayList<>();
	    	
    }
    public void add_node(Node node) {
    	liste_av_rack.add(node);
    }
    public int erFull() {
		return liste_av_rack.size();
    	
    }
    
    public int antProsessorer() { 
    		int antall_prosessorer = 0;
    		for (int i=0; i<liste_av_rack.size(); i++) {
    			antall_prosessorer += liste_av_rack.get(i).antProsessorer();
    		}
    		return antall_prosessorer;    				
    }
    public int noderMedNokMinne( int paakrevdMinne) {
		int antall_noder = 0 ;
		for (int i=0; i<liste_av_rack.size(); i++) {
			if (liste_av_rack.get(i).nokMinne(paakrevdMinne)){
				antall_noder += 1;
			}
		}
		
		return antall_noder ;
    }
}


class Node  {
	public int minne_storrelse;
	public int prosessor_antall;
       

	public Node(int minne_storrelse, int prosessor_antall) {
		
		this.minne_storrelse = minne_storrelse;
		this.prosessor_antall=prosessor_antall;
	}



    public int antProsessorer() {
        return this.prosessor_antall; 
    }
    public boolean nokMinne( int paakrevdMinne) {   //paakrevdMinne= requiredMemory
        if (paakrevdMinne <= this.minne_storrelse){
            return true;
        }
        else {
        	return false;
        }
    }
}

