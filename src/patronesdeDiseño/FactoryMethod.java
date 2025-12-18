package patronesdeDiseño;

public class FactoryMethod {
    public static void main(String[] args) {
        GeneradorDeFacturas generadorFacturas = new GeneradorDeFacturas();

        Factura facturaSinIVA = generadorFacturas.generarFactura(TipoFactura.IVA_0);
        float sinIVA = facturaSinIVA.generarImporte(100);

        Factura factura8IVA = generadorFacturas.generarFactura(TipoFactura.IVA_8);
        float IVA8 = factura8IVA.generarImporte(100);

        Factura factura16IVA = generadorFacturas.generarFactura(TipoFactura.IVA_16);
        float IVA16 = factura16IVA.generarImporte(100);

        System.out.println(sinIVA);
        System.out.println(IVA8);
        System.out.println(IVA16);
    }
}

interface Factura{
    float generarImporte(float importe);
}

class facturaCon16DeIVA implements Factura{

    @Override
    public float generarImporte(float importe) {
        return (importe * (16f / 100)) + importe;
    }
}

class facturaCon8DeIVA implements Factura{

    @Override
    public float generarImporte(float importe) {
        return (importe * (8f / 100)) + importe;
    }
}

class facturaSinIVA implements Factura{

    @Override
    public float generarImporte(float importe) {
        return importe;
    }
}

class GeneradorDeFacturas{
    public Factura generarFactura(TipoFactura tipoFactura) throws RuntimeException{
        Factura factura;
        switch (tipoFactura){
            case IVA_0 -> factura = new facturaSinIVA();
            case IVA_8 -> factura = new facturaCon8DeIVA();
            case IVA_16 -> factura = new facturaCon16DeIVA();
            default -> throw new RuntimeException("Tipo de factura incorrecto");
        }
        return factura;
    }
}


enum TipoFactura{
    IVA_0, IVA_8, IVA_16
}







