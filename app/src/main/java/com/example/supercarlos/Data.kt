package com.example.supercarlos
import java.util.Calendar

class Data(private var dia: Int, private var mes: Int, private var ano: Int) {
    init {

    };
    override  fun toString(): String{
        return "$dia/$mes/$ano";
    };

    fun setData(novoDia: Int, novoMes: Int, novoAno: Int){
        this.dia = novoDia;
        this.mes = novoMes;
        this.ano = novoAno;
    };

    fun antes(outraData: Data): Boolean{
        if (this.ano < outraData.ano) return true;
        if (this.ano == outraData.ano && this.mes < outraData.mes) return true;
        if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia < outraData.dia) return true;
        return false;
    };

    fun depois(outraData: Data): Boolean{
        if (this.ano > outraData.ano) return true;
        if (this.ano == outraData.ano && this.mes > outraData.mes) return true;
        if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia > outraData.dia) return true;
        return false;
    };

    fun igual(outraData: Data): Boolean{
        return this.dia == outraData.dia && this.mes == outraData.mes && this.ano == outraData.ano;
    };

    fun getDia(): Int = this.dia;
    fun getMes(): Int = this.mes;
    fun getAno(): Int = this.ano;

    companion object {
        fun dataHoje(): Data{
            val calendario = Calendar.getInstance();
            val dia = calendario.get(Calendar.DAY_OF_MONTH);
            val mes = calendario.get(Calendar.MONTH) + 1;
            val ano = calendario.get(Calendar.YEAR);
            return Data(dia, mes, ano);
        };
    };
};
