package dev.benjamin.models;

public enum Status {
    APPROVED{
        @Override
        public String toString(){
            return "Approved";
        }
    },
    PENDING{
        @Override
        public String toString(){
            return "Pending";
        }
    },
    DENIED{
        @Override
        public String toString(){
            return "Denied";
        }

    }
}
