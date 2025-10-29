package ss15_exception_handle_and_debug.bai_tap.controller;

import ss15_exception_handle_and_debug.bai_tap.common.exception.IllegalTriangleException;
import ss15_exception_handle_and_debug.bai_tap.services.ITriangle;
import ss15_exception_handle_and_debug.bai_tap.services.TriangleService;

public class TriangleController {
    private ITriangle triangle = new TriangleService();
    public boolean isTriangle(double side1, double side2, double side3) throws IllegalTriangleException {
        return triangle.checkIllegalTriangle(side1, side2, side3);
    }
}
