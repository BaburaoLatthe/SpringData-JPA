package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();

		int loanAmt = 6000;
		int age = 45;

		// arithmetic operator
		System.out.println(parser.parseExpression(10 + "* 10/2").getValue());
		System.out.println(parser.parseExpression("'Today is: '+ new java.util.Date()").getValue());

		// logical operator
		System.out.println(parser.parseExpression(false + " and true").getValue());

		// logical operator
		System.out.println(parser.parseExpression(age + " > 44").getValue());

		// logical operator
		System.out.println(parser.parseExpression(loanAmt + " > 5000" + " && " + loanAmt + " < 10000").getValue());

		// Relational operator
		System.out.println(parser.parseExpression("'sonoo'.length()==5").getValue());

		Inventor tesla = new Inventor("Nikola_Tesla", " May 1", "Serbian");
		EvaluationContext context = new StandardEvaluationContext(tesla);

		// Equals To
		Expression exp = parser.parseExpression("name == 'Nikola Tesla'");
		boolean result = exp.getValue(context, Boolean.class); // evaluates to true
		System.out.println("Name ::" + result);

		// Not Equals To
		Expression expNotEq = parser.parseExpression("name != 'Nikola Tesla'");
		boolean notEqResult = expNotEq.getValue(context, Boolean.class); // evaluates to true
		System.out.println("Name ::" + notEqResult);

		System.out.println(parser.parseExpression("'Welcome SPEL'+'!'").getValue());

	}

}
