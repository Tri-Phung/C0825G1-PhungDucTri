import { useForm } from 'react-hook-form'
import { zodResolver } from '@hookform/resolvers/zod'
import { z } from 'zod'
import { Form, Button, Container, Card } from 'react-bootstrap'

const bookSchema = z.object({
    title: z.string().min(1, 'Title không được bỏ trống'),
    quantity: z
        .string()
        .regex(/^\d+$/, "Quantity phải là số nguyên lớn hơn 0")
        .min(1, 'Quantity không được bỏ trống')
        .refine((val) => !isNaN(Number(val)), 'Quantity phải là số')
        .refine((val) => Number(val) >= 0, 'Quantity không được âm'),
})

function BookForm({ onSubmit, defaultValues, submitLabel, title }) {
    const {
        register,
        handleSubmit,
        formState: { errors, isSubmitting },
    } = useForm({
        resolver: zodResolver(bookSchema),
        defaultValues: {
            title: defaultValues?.title || '',
            quantity: defaultValues?.quantity?.toString() || '',
        },
    })

    const handleFormSubmit = (data) => {
        onSubmit({
            title: data.title,
            quantity: Number(data.quantity),
        })
    }

    return (
        <Container className="mt-4">
            <Card>
                <Card.Header as="h4">{title}</Card.Header>
                <Card.Body>
                    <Form onSubmit={handleSubmit(handleFormSubmit)}>
                        <Form.Group className="mb-3">
                            <Form.Label>Title</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Enter book title"
                                {...register('title')}
                                isInvalid={!!errors.title}
                            />
                            <Form.Control.Feedback type="invalid">
                                {errors.title?.message}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mb-3">
                            <Form.Label>Quantity</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Enter quantity"
                                {...register('quantity')}
                                isInvalid={!!errors.quantity}
                            />
                            <Form.Control.Feedback type="invalid">
                                {errors.quantity?.message}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Button variant="primary" type="submit" disabled={isSubmitting}>
                            {isSubmitting ? 'Đang xử lý...' : submitLabel}
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
        </Container>
    )
}

export default BookForm
