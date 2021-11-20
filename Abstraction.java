interface PlantsData 
{
    // Properties
    final String food = "Photosynthesis"; // رۆشنەپێکهاتن 
    // ماددەی کیمییای بۆ گەشە
    public enum Fertilizers_Type
    {
        Compost,Phosphorus,Potassium
    }
    
    // Methods
    void GiveFertilizers(Fertilizers_Type fertilizers);
    void ShowInfo();
}

abstract class Plants implements PlantsData
{
    // Properties
    private float height = 0.0f;
    protected String fertilizer; // ماددەی کیمییای بۆ گەشە
    
    // Methods
    protected void GrowthPerDay(float growRate){
        height += growRate + 0.001f;
    }

    @Override
    public void ShowInfo(){
        System.out.println("Food :" + food);
        System.out.println("Height :" + height);
        System.out.println("Fertilizer :" + fertilizer);
    }

    @Override
    public void GiveFertilizers(Fertilizers_Type fertilizer){
        if(fertilizer == Fertilizers_Type.Compost){
            this.fertilizer = "Compost";
            GrowthPerDay(0.1f);
        }
        else if(fertilizer == Fertilizers_Type.Phosphorus){
            this.fertilizer = "Phosphorus";
            GrowthPerDay(0.34f);
        }
        else if(fertilizer == Fertilizers_Type.Potassium){
            this.fertilizer = "Potassium";
            GrowthPerDay(0.39f);
        }
        else{
            GrowthPerDay(0.01f);
        }
    }

    // Abstract Methods
    abstract void Productive();
}
class WaterMelon extends Plants 
{
    public WaterMelon(){}

    @Override
    public void ShowInfo(){
        System.out.println("Plant -> WaterMelon");
        super.ShowInfo();
    }

    @Override
    public void Productive(){
        System.out.println("Productive :WaterMelon , Seed");
        System.out.println("Produce : 15% Oxegyn");
    }
}

class Flower extends Plants {
    
    public Flower(){}

    @Override
    public void ShowInfo(){
        System.out.println("Plant -> Flower");
        super.ShowInfo();
    }

    @Override
    public void Productive(){
        System.out.println("Productive :Seed");
        System.out.println("Produce : 30% Oxegyn");
    }
}

public class Abstraction {
    public static void main(String[] args){
        Plants flower = new Flower();
        Plants waterMelon = new WaterMelon();
        
        // Growing in 100 days
        for(int i=0; i < 100; i++)
        {
            flower.GiveFertilizers(Plants.Fertilizers_Type.Compost);
            
            if(i % 3 == 0) // سێ رۆژ جارەک خواردنی دەدەینێ
                waterMelon.GiveFertilizers(Plants.Fertilizers_Type.Phosphorus);
        }

        // Show Informations
        flower.ShowInfo();
        flower.Productive();
        waterMelon.ShowInfo();
        waterMelon.Productive();
    }
}
