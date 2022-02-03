package dev.benjamin.models;

public enum Status {
    APPROVED{
        @Override
        public String toString(){
            return "APPROVED";
        }
    },

    PENDING{
        @Override
        public String toString(){
            return "PENDING";
        }
    },

    DENIED{
        @Override
        public String toString(){
            return "DENIED";
        }

    }
}
