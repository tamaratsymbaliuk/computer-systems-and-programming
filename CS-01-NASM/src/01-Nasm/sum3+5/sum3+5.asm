section .text
global _start
_start:
    Load the numbers into registers
    mov eax, 3      ; First number
    mov ebx, 5      ; Second number

    ; Perform the addition
    add eax, ebx

    ; eax now contains the result, move it to rax to prepare for exit
    mov rax, eax

    ; Exit the program, returning the result
    ; On Linux, the system call for exit is 60, and the exit code is in rax
    mov rax, 60     ; syscall number for exit
    syscall         ; invoke the kernel to exit
    ; The result of the sum (8 in this case) will be in the exit code of the program
