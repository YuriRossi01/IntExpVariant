import java.util.HashMap;
import java.util.Map;

public class IntExp extends IntExpBaseVisitor<Double> {
    private final Map<String, Double> memory = new HashMap<>();

    @Override
    public Double visitMain(IntExpParser.MainContext ctx) {
        return visit(ctx.prog());
    }
    @Override
    public Double visitProg(IntExpParser.ProgContext ctx) {
        visit(ctx.init());
        return visit(ctx.exp());
    }

    @Override
    public Double visitInit(IntExpParser.InitContext ctx) {
        for(int i = 0; i <ctx.exp().size(); i++) {
            String id = ctx.ID(i).getText();
            Double value = visit(ctx.exp(i));
            System.out.println("\t" + id + " = " + value);
            memory.put(id, value);
        }
        return null;
    }
    @Override
    public Double visitNum(IntExpParser.NumContext ctx) {
        return Double.parseDouble(ctx.FLOAT().getText());
    }

    @Override
    public Double visitId(IntExpParser.IdContext ctx) {
        return memory.getOrDefault(ctx.ID().getText(), 0.0);
    }

    @Override
    public Double visitPow(IntExpParser.PowContext ctx) {
        return  Math.pow(visit(ctx.exp(0)), visit(ctx.exp(1)));
    }

    @Override
    public Double visitMulDivMod(IntExpParser.MulDivModContext ctx) {
        return switch (ctx.op.getType()){
            case IntExpParser.DIV -> visit(ctx.exp(0)) / visit(ctx.exp(1));
            case IntExpParser.MOD -> visit(ctx.exp(0)) % visit(ctx.exp(1));
            case IntExpParser.MUL -> visit(ctx.exp(0)) * visit(ctx.exp(1));
            default -> null;
        };
    }

    @Override
    public Double visitPlusSub(IntExpParser.PlusSubContext ctx) {
        return switch (ctx.op.getType()){
            case IntExpParser.PLUS -> visit(ctx.exp(0)) + visit(ctx.exp(1));
            case IntExpParser.SUB -> visit(ctx.exp(0)) - visit(ctx.exp(1));
            default -> null;
        };
    }

    @Override
    public Double visitPar(IntExpParser.ParContext ctx) {
        return visit(ctx.exp());
    }
}
