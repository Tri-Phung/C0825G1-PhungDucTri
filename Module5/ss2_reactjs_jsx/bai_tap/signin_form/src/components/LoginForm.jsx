import React from "react";
import {Form, Button, Container, Card, Row, Col, InputGroup} from 'react-bootstrap';
import {BootstrapFill} from 'react-bootstrap-icons';

const LoginForm = () => {
    return (
        <Container>
            <Row className="justify-content-md-center align-items-center" style={{minHeight: '100vh'}}>
                <Col xs={12} md={6} lg={4}>
                    <Card className="shadow-lg border-0 rounded-4">
                        <Card.Body className="p-5">
                            <div className="text-center">
                                <BootstrapFill color="#8409FB" size={50}/>
                            </div>
                            <div className="text-center mb-4">
                                <p className="fs-1">Please sign in</p>
                            </div>

                            <Form>
                                <Form.Group className="mb-3" controlId="formEmail">
                                    <Form.Label className="small fw-semibold">Email address</Form.Label>
                                    <Form.Control
                                        type="email"
                                        placeholder="Email address"
                                        className="py-2"
                                    />
                                </Form.Group>
                                <Form.Group className="mb-4" controlId="formPassword">
                                    <Form.Label className="small fw-semibold">Password</Form.Label>
                                    <Form.Control
                                        type="password"
                                        placeholder="Password"
                                        className="py-2"
                                    />
                                </Form.Group>
                                <div className="d-flex justify-content-center mb-4 small">
                                    <Form.Check type="checkbox" label="Remember me" id="rememberMe" />
                                </div>
                                <Button variant="primary" type="button" className="w-100 py-2 fw-bold shadow-sm">
                                    Sign in
                                </Button>
                            </Form>
                        </Card.Body>
                    </Card>
                    <p className="text-center text-muted mt-4 small">
                        © 2017–2021
                    </p>
                </Col>
            </Row>
        </Container>
    )
}

export default LoginForm;