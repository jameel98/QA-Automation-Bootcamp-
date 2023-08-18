package org.example.enums;

public enum BirdType {
    BARNOWL {
        String name = "Tytoalba";
        @Override
        public void sing() {
            System.out.println("screeee");
        }
    },
    BALDEAGLE {
        String name = "Haliaeetus leucocophalus";
        @Override
        public void sing() {
            System.out.println("kleek kik ik ik ki ik");
        }
    },
    ASIANKOEL {
        String name = "Eudynamys scolopaceus";
        @Override
        public void sing() {
            System.out.println("koo oooo");
        }
    },
    LOON {
        String name = "Gavia immer";
        @Override
        public void sing() {
            System.out.println("cooo leee");
        }
    };
    BirdType(){}
    public abstract void sing();
}