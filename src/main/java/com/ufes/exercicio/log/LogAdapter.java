package com.ufes.exercicio.log;

import com.ufes.exercicio.model.RegistroLog;
import java.io.File;
import java.io.IOException;

public abstract class LogAdapter {

    protected File file;

    public abstract void escreve(RegistroLog... registerLog) throws IOException;

    public LogAdapter(String fileName) {
        this.file = new File(fileName);
    }

}
