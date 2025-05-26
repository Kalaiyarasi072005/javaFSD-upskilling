// QuantumInstruments.java
public class QuantumInstruments {
    interface Playable {
        void play();
        void tune();
    }
    
    static class QuantumGuitar implements Playable {
        private String tuning;
        
        public QuantumGuitar(String tuning) {
            this.tuning = tuning;
        }
        
        @Override
        public void play() {
            System.out.println("Playing quantum guitar with " + tuning + " tuning");
            System.out.println("Sound exists in all possible frequencies simultaneously");
        }
        
        @Override
        public void tune() {
            System.out.println("Tuning quantum guitar to " + tuning);
            System.out.println("All strings are perfectly in tune through quantum entanglement");
        }
    }
    
    static class QuantumPiano implements Playable {
        private int octaves;
        
        public QuantumPiano(int octaves) {
            this.octaves = octaves;
        }
        
        @Override
        public void play() {
            System.out.println("Playing quantum piano with " + octaves + " octaves");
            System.out.println("All keys are pressed and not pressed simultaneously");
        }
        
        @Override
        public void tune() {
            System.out.println("Tuning quantum piano");
            System.out.println("Each note collapses to perfect pitch when observed");
        }
    }
    
    public static void main(String[] args) {
        Playable[] instruments = {
            new QuantumGuitar("Standard"),
            new QuantumPiano(88)
        };
        
        for (Playable instrument : instruments) {
            instrument.tune();
            instrument.play();
            System.out.println();
        }
    }
}