package main;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		ArrayList<Locadora> locadoras = new ArrayList<Locadora>();
		Categoria cat_basic = new Categoria("Basic", false, "Mecânica", 4, false);
		Categoria cat_medium = new Categoria("Medium", false, "Hidráulica", 4, true);
		Categoria cat_premium = new Categoria("Premium", true, "Elétrica", 4, true);
		
		Localizacao loc_localiza = new Localizacao("Rua 235", "Centro", "Goiânia", "Goiás");
		Locadora localiza = new Locadora("Locadora Localiza", "16.778.360/0001-59", "(62) 3332-0000", loc_localiza);
		Veiculo veic_localiza1 = new Veiculo("VW", "Gol", 2017, "Vidro elétrico", 200, cat_basic);
		Veiculo veic_localiza2 = new Veiculo("Fiat", "Palio", 2016, "Insufilm", 177, cat_basic);
		Veiculo veic_localiza3 = new Veiculo("Honda", "Civic", 2017, "Central multimídia", 310, cat_premium);
		Veiculo veic_localiza4 = new Veiculo("VW", "Polo", 2018, "Vidro elétrico", 278, cat_medium);
		localiza.addVeiculo(veic_localiza1);
		localiza.addVeiculo(veic_localiza2);
		localiza.addVeiculo(veic_localiza3);
		localiza.addVeiculo(veic_localiza4);
		locadoras.add(localiza);
		
		Localizacao loc_facil = new Localizacao("Avenida Jamel", "Jardim Goiás", "Goiânia", "Goiás");
		Locadora facil = new Locadora("Fácil Locadora", "11.312.412/0001-19", "(62) 4531-1235", loc_facil);
		Veiculo veic_facil1 = new Veiculo("Fiat", "Mobi", 2019, "Sem acessórios", 155, cat_basic);
		Veiculo veic_facil2 = new Veiculo("Renault", "Kwid", 2018, "Insufilm", 155, cat_basic);
		Veiculo veic_facil3 = new Veiculo("Fiat", "Argo", 2018, "Central multimídia", 267, cat_medium);
		Veiculo veic_facil4 = new Veiculo("Toyota", "Corolla", 2019, "Bancos em couro, central multimídia", 380, cat_premium);
		facil.addVeiculo(veic_facil1);
		facil.addVeiculo(veic_facil2);
		facil.addVeiculo(veic_facil3);
		facil.addVeiculo(veic_facil4);
		locadoras.add(facil);
		
		for(int i = 0; i < locadoras.size(); i++) {
			System.out.println(locadoras.get(i).toString() + "\n");
		}
	}

}
