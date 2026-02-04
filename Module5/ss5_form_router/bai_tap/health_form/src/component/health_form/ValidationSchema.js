import {z} from 'zod';

export const UserInfoSchema = z.object({
    name: z.string().min(1,"Required"),
    passport: z.string().min(1,"Required"),
    dob: z.coerce.date().min(new Date('1900-01-01'),'Date of birth must be greater than 1/1/1900').
        max(new Date(),'Date of birth cannot in the future'),
    gender: z.string().min(1,"Required"),
    nationality: z.string().min(1,"Required"),
    company: z.string().optional(),
    department: z.string().optional(),
    hasInsurance: z.boolean().optional(),
    province: z.string().min(1,"Required"),
    district: z.string().min(1,"Required"),
    ward: z.string().min(1,"Required"),
    address: z.string().min(1,"Required"),
    phone: z.string().min(1, "Required").regex(/^[0-9]{10,11}$/,"Invalid phone number"),
    email: z.string()
        .min(1, "Required")
        .regex(/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i, "Invalid email address")
});

export const HealthFormSchema = z.object({
    countries: z.string().optional(),
    symptoms: z.array(z.string().optional()),
    contact: z.array(z.string().optional())
});