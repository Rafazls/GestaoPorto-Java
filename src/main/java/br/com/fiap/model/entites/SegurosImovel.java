package br.com.fiap.model.entites;

import br.com.fiap.Service.ImovelEnum;
import br.com.fiap.Service.PrecificacaoImovel;
import br.com.fiap.Service.SeguroService;

public class SegurosImovel extends Seguros implements PrecificacaoImovel, SeguroService {

    private ImovelEnum imovel;

    public SegurosImovel(String tipo, double valor, Long id_cliente) {
        super(tipo, valor, id_cliente);
    }

    public SegurosImovel(String tipo, double valor, Long idCliente, ImovelEnum imovel) {
        super(tipo, valor, idCliente);
        this.imovel = imovel;
        definirPrecoPorTipo(imovel);
    }

    @Override
    public void definirPrecoPorTipo(ImovelEnum imovel) {
        if (imovel == null) {
            throw new IllegalArgumentException("Tipo de imóvel inválido");
        }

        double valorBase = valorSeguroPorImovel(imovel);
        switch (imovel) {
            case APARTAMENTO:
                valor = valorBase + (valorBase * 0.05); // 5% a mais para apartamentos
                break;
            case CASA:
                valor = valorBase + (valorBase * 0.10); // 10% a mais para casas
                break;
            case CHACARA:
                valor = valorBase + (valorBase * 0.15); // 15% a mais para chácaras
                break;
            default:
                valor = valorBase;
        }

        setTipo("seguroImovel");
        setValor(valor);
    }

    @Override
    public double valorSeguroPorImovel(ImovelEnum imovel) {
        return 0.03 * imovel.getValorMercado(); // 3% do valor de mercado do imóvel
    }

    @Override
    public void define() {
        System.out.println("Seguro de imóvel");
    }
}
