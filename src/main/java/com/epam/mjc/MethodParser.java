package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String modifier = null;
        String returnType;
        String methodName;
        String args = signatureString.split("\\(")[1];

        String[] argumentter = args.split(" ");
        String[] strArray = signatureString.split(" ");
        if ("private public protected".contains(strArray[0])){
            modifier = strArray[0];
            returnType = strArray[1];
            methodName = strArray[2].split("\\(")[0];
        }else {
            returnType = strArray[0];
            methodName = strArray[1].split("\\(")[0];
        }

        List<MethodSignature.Argument> arguments = new ArrayList<>();
        for (int i = 0; i < argumentter.length-1; i = i+2) {
            arguments.add(new MethodSignature.Argument(argumentter[i], argumentter[i+1].substring(0,argumentter[i+1].length()-1)));
        }

        MethodSignature methodSignature =new MethodSignature(methodName, arguments);
        methodSignature.setAccessModifier(modifier);
        methodSignature.setReturnType(returnType);
        return methodSignature;
    }
}
