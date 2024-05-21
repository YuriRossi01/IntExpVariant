// Generated from Y:/Universita/Linguagg/IntExp/src/IntExp.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IntExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IntExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IntExpParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(IntExpParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntExpParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(IntExpParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntExpParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(IntExpParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code par}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar(IntExpParser.ParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivMod}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(IntExpParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code num}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(IntExpParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pow}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(IntExpParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(IntExpParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusSub}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusSub(IntExpParser.PlusSubContext ctx);
}