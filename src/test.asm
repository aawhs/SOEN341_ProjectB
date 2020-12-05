Fct    ret
       call    Fct      ; OK, only labels are permitted.
       br      Fct      ; OK, only labels are permitted.
       lda     Fct      ; OK, only labels are permitted.
       halt
       and
       pop
       dup
       ldc.i3  -4       ; OK, number <i3> [-4..3].
       ldc.i3  3        ; OK, number <i3> [-4..3].
       trap
