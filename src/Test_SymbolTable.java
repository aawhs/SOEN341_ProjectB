public class Test_SymbolTable {
    public static void main(String[] args) {
        System.out.print("Test SymbolTable\n");
        System.out.print(String.format("pop 0x01"));

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.put("pop", 0x01);
        System.out.print("\npop " + symbolTable.toHex((Integer)symbolTable.get("pop")));
    }
}
