package com.inditex.inditex_technical_test.exception;

public class AlbumDataInternalServerErrorException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msj;

    public AlbumDataInternalServerErrorException(){

    }

    public AlbumDataInternalServerErrorException(String msj){
        this.msj = msj;
    }


    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
}
