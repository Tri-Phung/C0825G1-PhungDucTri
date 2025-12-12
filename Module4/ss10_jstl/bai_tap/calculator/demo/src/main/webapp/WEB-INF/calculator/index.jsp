<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f5f5f5;
        }

        h1 {
            font-size: 32px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        fieldset {
            border: 2px solid #999;
            padding: 20px;
            background-color: #fff;
            max-width: 400px;
        }

        legend {
            font-weight: bold;
            padding: 0 10px;
        }

        .form-group {
            margin-bottom: 15px;
            display: flex;
            align-items: center;
        }

        label {
            display: inline-block;
            width: 150px;
            text-align: right;
            margin-right: 10px;
        }

        input[type="text"] {
            padding: 5px;
            border: 1px solid #ccc;
            width: 150px;
        }

        select {
            padding: 5px;
            border: 1px solid #ccc;
            width: 120px;
        }

        .btn-calculate {
            margin-left: 160px;
            padding: 5px 20px;
            background-color: #e0e0e0;
            border: 1px solid #999;
            border-radius: 3px;
            cursor: pointer;
        }

        .btn-calculate:hover {
            background-color: #d0d0d0;
        }
        .warning {
            color: red;
        }
    </style>
</head>
<body>
<h1>Simple Calculator</h1>

<form action="calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>

        <div class="form-group">
            <label for="firstOperand">First operand:</label>
            <input type="text" id="firstOperand" name="num1" value="" />
        </div>

        <div class="form-group">
            <label for="operator">Operator:</label>
            <select id="operator" name="operation">
                <option value="addition">Addition</option>
                <option value="subtraction">Subtraction</option>
                <option value="multiplication">Multiplication</option>
                <option value="division">Division</option>
            </select>
        </div>

        <div class="form-group">
            <label for="secondOperand">Second operand:</label>
            <input type="text" id="secondOperand" name="num2" value="" />
        </div>

        <button type="submit" class="btn-calculate">Calculate</button>
    </fieldset>
    <p class="warning">${message}</p>
</form>
</body>
</html>