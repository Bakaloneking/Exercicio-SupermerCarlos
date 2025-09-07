package com.example.supercarlos

abstract class Genero{
    abstract var nome: String;
};

class Leite : Genero(){
    override var nome: String = "Leite";

};

class Presunto : Genero(){
    override var nome: String = "Presunto";
};

class Achocolatado : Genero(){
    override var nome: String = "Achocolatado";
};

