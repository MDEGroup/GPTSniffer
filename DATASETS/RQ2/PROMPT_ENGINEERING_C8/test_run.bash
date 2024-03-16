#!/bin/bash

#$ -S /bin/bash
#$ -pe mpi 4
#$ -cwd
#$ -o console.out
#$ -l h=compute-0-3.local

export CUDA_VISIBLE_DEVICES=MIG-cbc43902-8045-5008-b0be-7a9289ec0c5e


bash -i run_script.bash
