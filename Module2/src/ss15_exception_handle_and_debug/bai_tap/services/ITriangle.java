package ss15_exception_handle_and_debug.bai_tap.services;

import ss15_exception_handle_and_debug.bai_tap.common.exception.IllegalTriangleException;

public interface ITriangle {
    boolean checkIllegalTriangle(double side1, double side2, double side3) throws IllegalTriangleException;
}
