package com.example.razok.percents;

public class SimpleViewModel{
        private String exData;
        public SimpleViewModel(String exData){
            setExData(exData);
        }

    public void setExData(String exData) {
        this.exData = exData;
    }


    public String getExData(){
            return exData;
    }
}
