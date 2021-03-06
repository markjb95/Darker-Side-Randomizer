public class Moon {
    private String name;
    private String king;
    private String[] achTags;
    private int achLevel;
    private boolean firstVisit;

    //not intended for use, just necessary to allow NecessaryAction to inherit from Moon
    public Moon () {
        achTags = new String[0];
    }

    public Moon(String moonName, String kingdom, boolean first, String[] tagArray){
        name = moonName;
        king = kingdom;
        achTags = tagArray;
        firstVisit = first;
    }

    public Moon(String moonName, String kingdom, int level, String[] tagArray){
        name = moonName;
        king = kingdom;
        achTags = tagArray;
        achLevel = level;
    }

    public String toString(){
        if(!king.equals("Achievements"))
            return "{\n\t\"name\": \""+name+"\",\n\t\"kingdom\": \""+king+"\",\n\t\"first\": "+ getFirstVisit().toString()+"\n}";
        return "{\n\t\"name\": \""+name+"\",\n\t\"kingdom\": \""+king+"\",\n\t\"tag\": \""+achTags[0]+"\",\n\t\"count\": \""+achTags[1]+"\"\n}";
    }

    public String getName(){
        return name;
    }

    public String[] getTags(){
        return achTags;
    }

    public String getKingdom(){
        return king;
    }

    public Boolean getFirstVisit(){
        return firstVisit;
    }

    public int getLevel(){
        return achLevel;
    }

    public boolean checkTags(String target){
        boolean tagged = false;
        for (String s: achTags){
            if(s.equals(target))
                tagged = true;
        }
        return tagged;
    }

    public static int compareByVisit(Moon m1, Moon m2) {
        Moon[] comparands = {m1, m2};
        int[] comparandBucket = {1, 2};
        for (int i = 0; i < comparands.length; i++) {
            Moon m = comparands[i];
            String king = m.getKingdom();
            boolean fV = m.getFirstVisit();
            String name = m.getName();
            if (king.equals("Cascade") && fV)
                comparandBucket[i] = 0;
            else if (king.equals("Sand") && fV)
                comparandBucket[i] = 1;
            else if (king.equals("Lake") && fV)
                comparandBucket[i] = 2;
            else if (king.equals("Wooded") && fV)
                comparandBucket[i] = 3;
            else if (king.equals("Cloud") && fV)
                comparandBucket[i] = 4;
            else if (king.equals("Lost") && fV)
                comparandBucket[i] = 5;
            else if (king.equals("Metro") && fV)
                comparandBucket[i] = 6;
            else if (king.equals("Snow") && fV)
                comparandBucket[i] = 7;
            else if (king.equals("Seaside") && fV)
                comparandBucket[i] = 8;
            else if (king.equals("Luncheon") && fV)
                comparandBucket[i] = 9;
            else if (king.equals("Ruined") && fV)
                comparandBucket[i] = 10;
            else if (king.equals("Bowser's") && fV)
                comparandBucket[i] = 11;
            else if (king.equals("Moon") && fV)
                comparandBucket[i] = 12;
            else if (king.equals("Mushroom") && fV)
                comparandBucket[i] = 13;
            else if (king.equals("Snow") && !fV)
                comparandBucket[i] = 14;
            else if (king.equals("Cascade") && !fV)
                comparandBucket[i] = 15;
            else if (king.equals("Bowser's") && !fV)
                comparandBucket[i] = 16;
            else if (king.equals("Seaside") && !fV)
                comparandBucket[i] = 17;
            else if (king.equals("Lake") && !fV)
                comparandBucket[i] = 18;
            else if (king.equals("Sand") && !fV)
                comparandBucket[i] = 19;
            else if (king.equals("Metro") && !fV)
                comparandBucket[i] = 20;
            else if (king.equals("Wooded") && !fV)
                comparandBucket[i] = 21;
            else if (king.equals("Luncheon") && !fV)
                comparandBucket[i] = 22;
            else if (king.equals("Cap") && !fV)
                comparandBucket[i] = 23;
            else if (king.equals("Cloud") && !fV)
                comparandBucket[i] = 24;
            else if (king.equals("Lost") && !fV)
                comparandBucket[i] = 25;
            else if (king.equals("Ruined") && !fV)
                comparandBucket[i] = 26;
            else if (king.equals("Moon") && !fV)
                comparandBucket[i] = 27;
            else if (king.equals("Dark Side"))
                comparandBucket[i] = 28;
            else if (king.equals("Achievements"))
                comparandBucket[i] = 29;
        }
        if (comparandBucket[0] < comparandBucket[1])
            return -1;
        if (comparandBucket[0] > comparandBucket[1])
            return 1;
        return Lists.indexOfMoon(m1) < Lists.indexOfMoon(m2) ? -1 : 1;
    }

    public static int compareByKingdom(Moon m1, Moon m2) {
        return Lists.indexOfMoon(m1) < Lists.indexOfMoon(m2) ? -1 : 1;
    }
}
